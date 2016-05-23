package controller;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Bus;
import entities.Stops;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class UpdateBusRoute
 */
@WebServlet("/UpdateBusRoute")
public class UpdateBusRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBusRoute() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SessionFactory sf;
		try {

			int busNo = Integer.parseInt(request.getParameter("busNo"));
			String driverName = request.getParameter("driverName");
			String driverContactNo = request.getParameter("contactNumber");
			String stopNames[] = request.getParameterValues("stopName");
			String stopTime[] = request.getParameterValues("stopTime");

			Bus bus = new Bus();
			bus.setBusNo(busNo);
			bus.setDriverName(driverName);
			bus.setDriverContactNo(driverContactNo);
			
			sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			Transaction t = null;

			try {
				t = session.beginTransaction();
				session.update(bus);
				session.getTransaction().commit();
				session.clear();
				session.createQuery("DELETE from Stops s where s.busNo = :busNo").setInteger("busNo", busNo).executeUpdate();
				for (int i = 0; i < stopNames.length; i++) {
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");
					Date d = df.parse(stopTime[i]);
					Stops stop = new Stops(bus.getBusNo(), stopNames[i], new Time(d.getTime()));
					session.save(stop);
					session.clear();
					
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/RouteUpdateMessage.jsp");
			    rd.forward(request, response);
			} catch (RuntimeException e) {
				e.printStackTrace();
				t.rollback();
			} finally {
				session.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
