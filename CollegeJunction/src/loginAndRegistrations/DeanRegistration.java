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
import users.Dean;
import users.Faculty;

/**
 * Servlet implementation class DeanRegistration
 */
@WebServlet("/DeanRegistration")
public class DeanRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeanRegistration() {
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
		
		Dean d = new Dean();
		d.setName(name);
		d.setEmail(email);
		d.setDepartment(department);
		d.setPassword(password);
		
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		try{
			tx= session.beginTransaction();
			session.save(d);
			tx.commit();
			request.setAttribute("msg","New Dean Added Succesfully");
		}catch(RuntimeException e){
			e.printStackTrace();
			String err = e.getCause().toString();
			request.setAttribute("msg",err.substring(err.indexOf(':')+1));
			tx.rollback();
		}finally{
			session.close();
		}
		request.getServletContext().getRequestDispatcher("/admin/viewDeans.jsp").forward(request, response);
	}

}
