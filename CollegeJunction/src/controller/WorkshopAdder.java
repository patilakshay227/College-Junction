package controller;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Workshops;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class WorkshopAdder
 */
@WebServlet("/WorkshopAdder")
public class WorkshopAdder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkshopAdder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String venue = request.getParameter("venue");
		String regLastDate = request.getParameter("regLastDate");
		String details = request.getParameter("details");
		try{
			int regFee = Integer.parseInt(request.getParameter("regFee"));
			Workshops w = new Workshops();
			w.setName(name);
			w.setVenue(venue);
			w.setRegLastDate(regLastDate);
			w.setDate(date);
			w.setDetails(details);
			w.setRegFee(regFee);
			
			SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(w);
				tx.commit();
				request.setAttribute("msg", "Workshop Added Succesfully");
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
		
		request.getServletContext().getRequestDispatcher("/admin/viewWorkshops.jsp").forward(request, response);
	}

}
