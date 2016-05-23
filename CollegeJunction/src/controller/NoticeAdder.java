package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

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

import entities.Notices;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class NoticeAdder
 */
@MultipartConfig
@WebServlet("/NoticeAdder")
public class NoticeAdder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeAdder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		Part filePart = request.getPart("pdfFile");
		InputStream is = filePart.getInputStream();
		byte[] pdf = new byte[(int)filePart.getSize()];
		while(is.read(pdf)!=-1){
			
		}
		Notices n = new Notices();
		n.setTitle(title);
		n.setPdf(pdf);
		n.setDate(new Date(new java.util.Date().getTime()));
		
		try{
			SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(n);
				tx.commit();
				request.setAttribute("msg", "Notice Added Succesfully");
			} catch (RuntimeException ex) {
				ex.printStackTrace();
				tx.rollback();
				request.setAttribute("msg", ex.getCause().toString());
			}finally{
				session.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msg", e.getCause().toString());
		}
		request.getServletContext().getRequestDispatcher("/admin/viewNotices.jsp").forward(request, response);
	}

}
