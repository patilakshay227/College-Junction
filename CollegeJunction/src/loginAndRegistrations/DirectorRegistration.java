package loginAndRegistrations;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.SessionFactoryBuilder;
import users.Director;
import users.Faculty;

/**
 * Servlet implementation class DirectorRegistration
 */
@WebServlet("/DirectorRegistration")
public class DirectorRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectorRegistration() {
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
		// TODO Auto-generated method stub
		String name= request.getParameter("name");
		String email = request.getParameter("email");
		String password= request.getParameter("password");
		String department = request.getParameter("department");
		
		Director d = new Director();
		d.setName(name);
		d.setEmail(email);
		d.setPassword(password);
		
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		try{
			tx= session.beginTransaction();
			session.createQuery("Delete from Director").executeUpdate();
			session.clear();
			session.save(d);
			tx.commit();
			request.setAttribute("msg","New Director Added Succesfully");
		}catch(RuntimeException e){
			e.printStackTrace();
			String err = e.getCause().toString();
			request.setAttribute("msg",err.substring(err.indexOf(':')+1));
			tx.rollback();
		}finally{
			session.close();
		}
		request.getServletContext().getRequestDispatcher("/admin/viewDirector.jsp").forward(request, response);
	}

}
