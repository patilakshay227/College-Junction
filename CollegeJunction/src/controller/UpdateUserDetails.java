package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.omg.CORBA.Request;

import hibernate.SessionFactoryBuilder;
import users.Dean;
import users.Director;
import users.Faculty;
import users.TPO;

/**
 * Servlet implementation class UpdateUserDetails
 */
@WebServlet("/UpdateUserDetails")
public class UpdateUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserDetails() {
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

		String userType = request.getParameter("userType");
		String name = request.getParameter("name");
		String oldEmail = request.getParameter("oldEmail");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		RequestDispatcher rd = null;
		try {

			switch (userType) {

			case "Faculty":
				tx = session.beginTransaction();
				Faculty f = (Faculty) session.get(Faculty.class, oldEmail);
				if (!oldEmail.equals(email))
					session.delete(f);
				f.setName(name);
				f.setDepartment(request.getParameter("department"));
				f.setEmail(email);
				f.setPassword(password);
				session.saveOrUpdate(f);
				tx.commit();
				rd = request.getServletContext().getRequestDispatcher("/admin/viewFaculties.jsp");
				break;

			case "Dean":
				tx = session.beginTransaction();
				Dean d = (Dean) session.get(Dean.class, oldEmail);
				if (!oldEmail.equals(email))
					session.delete(d);
				d.setName(name);
				d.setDepartment(request.getParameter("department"));
				d.setEmail(email);
				d.setPassword(password);
				session.saveOrUpdate(d);
				tx.commit();
				rd = request.getServletContext().getRequestDispatcher("/admin/viewDeans.jsp");
				break;

			case "Director":

				tx = session.beginTransaction();
				Director dir = (Director) session.get(Director.class, oldEmail);
				if (!oldEmail.equals(email))
					session.delete(dir);
				dir.setName(name);
				dir.setEmail(email);
				dir.setPassword(password);
				session.saveOrUpdate(dir);
				rd = request.getServletContext().getRequestDispatcher("/admin/viewDirector.jsp");
				tx.commit();
				break;
				
			case "TPO":

				tx = session.beginTransaction();
				TPO tpo = (TPO) session.get(TPO.class, oldEmail);
				if (!oldEmail.equals(email))
					session.delete(tpo);
				tpo.setName(name);
				tpo.setEmail(email);
				tpo.setPassword(password);
				session.saveOrUpdate(tpo);
				rd = request.getServletContext().getRequestDispatcher("/admin/viewTPO.jsp");
				tx.commit();
				break;
			}
			request.setAttribute("msg", userType + " information updated successfully");
		} catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
			request.setAttribute("msg", e.getCause());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		rd.forward(request, response);
	}

}
