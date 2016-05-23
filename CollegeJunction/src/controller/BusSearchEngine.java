package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Bus;
import entities.Stops;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class BusSearchEngine
 */
@WebServlet("/BusSearchEngine")
public class BusSearchEngine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BusSearchEngine() {
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

		String searchType = request.getParameter("searchType");
		String stopName = request.getParameter("stopName");
		
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			if (searchType.equals("searchByBusNo")) {
				
				int busNo = Integer.parseInt(request.getParameter("busNo"));
				tx = session.beginTransaction();
				Bus bus = (Bus) session.get(Bus.class, busNo);
				String hql = "From Stops s where s.busNo = :busNo ORDER BY s.time ASC";
				Query query = session.createQuery(hql);
				query.setInteger("busNo", bus.getBusNo());
				List<Stops> stops = query.list();
				
				request.setAttribute("searchType", "busNo");
				request.setAttribute("bus", bus);
				request.setAttribute("stops", stops);
				

			} else {

				String hql = "From Stops s where s.stopName = :stopName ORDER BY s.time desc";
				Query query = session.createQuery(hql);
				query.setString("stopName", stopName);
				List<Stops> stopslist = query.list();
				List<Bus> busList = new ArrayList<Bus>();
				for(int i=0;i<stopslist.size();i++){
					
					busList.add( (Bus)session.get(Bus.class, stopslist.get(i).getBusNo()));
				}
				if(busList.isEmpty()){
					throw new ArrayIndexOutOfBoundsException();
				}
				request.setAttribute("searchType", "Stop Name");
				request.setAttribute("stopName", stopName);
				request.setAttribute("busList", busList);
				request.setAttribute("stopslist", stopslist);
			}
		} catch (NullPointerException ne) {
			request.setAttribute("errorMsg", "Bus Not Found");
			ne.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e){
			request.setAttribute("errorMsg", "No Bus goes through "+stopName);
		}catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ShowBus.jsp");
	    rd.forward(request, response);
	    
	}

}
