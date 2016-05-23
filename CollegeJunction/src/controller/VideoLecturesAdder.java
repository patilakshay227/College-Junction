package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.VideoLectures;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class VideoLecturesAdder
 */
@WebServlet("/VideoLecturesAdder")
public class VideoLecturesAdder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoLecturesAdder() {
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
		
		String title = request.getParameter("title");
		String department = request.getParameter("department");
		byte year = Byte.parseByte(request.getParameter("year"));
		String description = request.getParameter("description");
		String link = request.getParameter("videoLink");
		
		VideoLectures vl = new VideoLectures();
		vl.setDepartment(department);
		vl.setDescription(description);
		vl.setLink(link);
		vl.setTitle(title);
		vl.setYear(year);
		vl.setUploader("akshaydapora@gmail.com");
		
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(vl);
			tx.commit();
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
			response.sendRedirect("./myVideoLectures.jsp");
		}
		
		
	}

}
