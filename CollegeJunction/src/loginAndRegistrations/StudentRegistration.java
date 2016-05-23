package loginAndRegistrations;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.SessionFactoryBuilder;
import users.Faculty;
import users.Student;

/**
 * Servlet implementation class StudentRegistration
 */
@WebServlet("/StudentRegistration")
public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentRegistration() {
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

		String rollNo = request.getParameter("rollNo");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String branch = request.getParameter("branch");

		Student s = new Student();
		s.setRollNo(rollNo);
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setBranch(branch);
		
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			String err = e.getCause().toString();
			tx.rollback();
			request.setAttribute("errMsg", err);
			request.getServletContext().getRequestDispatcher("/admin/viewFaculties.jsp").forward(request, response);
			return;
		} finally {
			session.close();
		}
		 request.getSession().setAttribute("user", s);
		 request.getSession().setAttribute("userType","Student");
		 response.sendRedirect("./userHome.jsp");
		 
	}

}
