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

import entities.MotivationalThought;
import entities.Research;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class SaveMotivationalThought
 */
@WebServlet("/SaveMotivationalThought")
public class SaveMotivationalThought extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveMotivationalThought() {
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
			
			String thought = request.getParameter("thought");
			
			Date d = new Date();
			java.sql.Date date = new java.sql.Date(d.getTime());
			java.sql.Time time = new Time(d.getTime());
			
			
			MotivationalThought mt = new MotivationalThought();
			mt.setThought(thought);
			mt.setUploadDate(date);
			mt.setUploadTime(time);
			
			SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx= null;
			try{
				tx = session.beginTransaction();
				session.save(mt);
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
