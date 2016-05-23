package controller;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Poetry;
import entities.Research;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class SaveResearch
 */
@WebServlet("/SaveResearch")
public class SaveResearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveResearch() {
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
		try{
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			
			Date d = new Date();
			java.sql.Date date = new java.sql.Date(d.getTime());
			java.sql.Time time = new Time(d.getTime());
			
			
			Research r = new Research();
			r.setTitle(title);
			r.setDescription(description);
			r.setUploadDate(date);
			r.setUploadTime(time);
			
			SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx= null;
			try{
				tx = session.beginTransaction();
				session.save(r);
				tx.commit();
			}catch(RuntimeException e){
				e.printStackTrace();
				tx.rollback();
				request.setAttribute("errMsg", e.getMessage());
			}
			
			request.setAttribute("msg", "Your content is posted succesfully");
			
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("errMsg", e.getMessage());
			}
			
			request.getServletContext().getRequestDispatcher("/AddSkillSuccess.jsp").forward(request, response);

	}

}
