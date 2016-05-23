package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Photography;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class SavePhotography
 */
@MultipartConfig
@WebServlet("/SavePhotography")
public class SavePhotography extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SavePhotography() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			String title = request.getParameter("title");
			String caption = request.getParameter("caption");
			Part filePart = request.getPart("photo");
			InputStream is = filePart.getInputStream();
			//System.out.println(filePart.getSize());
			byte[] photo = new byte[(int) filePart.getSize()];
			while ((is.read(photo)) != -1) {
				// storing in photo buffer
			}
			Photography pg = new Photography();
			Date d = new Date();
			java.sql.Date date = new java.sql.Date(d.getTime());
			java.sql.Time time = new Time(d.getTime());
			pg.setTitle(title);
			pg.setCaption(caption);
			pg.setPhoto(photo);
			pg.setUploadDate(date);
			pg.setUploadTime(time);

			SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(pg);
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errMsg", e.getMessage());
				tx.rollback();
			} finally {
				session.close();
			}
			request.setAttribute("msg", "Your content uploaded succesfully :)");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
		}
		request.getServletContext().getRequestDispatcher("/AddSkillSuccess.jsp").forward(request, response);
	}

}
