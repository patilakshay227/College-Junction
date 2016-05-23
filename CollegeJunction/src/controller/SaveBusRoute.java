package controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Bus;
import entities.Stops;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class SaveBusRoute
 */
@WebServlet("/SaveBusRoute")
public class SaveBusRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveBusRoute() {
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
				session.save(bus);
				session.getTransaction().commit();
				session.clear();
				for(int i=0;i<stopNames.length;i++){
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");
					Date d = df.parse(stopTime[i]);
					Stops stop = new Stops(bus.getBusNo(),stopNames[i],new Time(d.getTime()));
					session.save(stop);
					session.clear();
					System.out.println("\n\n\nSuccess........\n\n");
					request.setAttribute("msg", "Bus Route Added Succesfully...");
				}
				
			} catch (RuntimeException e) {
				e.printStackTrace();
					t.rollback();
					request.setAttribute("msg", "Oops Something went Wrong :( ");
			} finally {
				session.close();
			}
			
			
			

		} catch (NumberFormatException ne) {
			ne.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			if(e instanceof SQLIntegrityConstraintViolationException){
				request.setAttribute("msg", "Bus Route Already exist. Please Update it through Update Link.");
			}
			else{
				request.setAttribute("msg", "Oops Something went Wrong :( ");
			}
			
		}
	}

}
