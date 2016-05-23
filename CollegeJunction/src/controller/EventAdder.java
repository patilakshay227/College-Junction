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

import entities.Events;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class EventAdder
 */
@WebServlet("/EventAdder")
public class EventAdder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EventAdder() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String venue = request.getParameter("venue");
		String regLastDate = request.getParameter("regLastDate");
		String details = request.getParameter("details");

		Events e = new Events();
		e.setName(name);
		e.setVenue(venue);
		e.setRegLastDate(regLastDate);
		e.setDate(date);
		e.setDetails(details);

		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(e);
			tx.commit();
			request.setAttribute("msg", "Event Added Succesfully");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			tx.rollback();
			request.setAttribute("msg", ex.getCause().toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("msg", ex.getCause().toString());
		} finally {
			session.close();
		}
		request.getServletContext().getRequestDispatcher("/admin/viewEvents.jsp").forward(request, response);
	}

}
