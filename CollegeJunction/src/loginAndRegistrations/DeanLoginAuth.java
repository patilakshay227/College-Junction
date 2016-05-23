package loginAndRegistrations;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.SessionFactoryBuilder;
import users.Dean;
import users.Faculty;

/**
 * Servlet implementation class DeanLoginAuth
 */
@WebServlet("/DeanLoginAuth")
public class DeanLoginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeanLoginAuth() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		 try{
			
			 SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			 Session session = sf.openSession();
			 session.beginTransaction();
			 String hql = "From Dean where email = :email and password = :password";
			 Query query = session.createQuery(hql);
			 query.setString("email", email);
			 query.setString("password", password);
			 Dean d =  (Dean) query.uniqueResult();
			 if(d!=null){
				 HttpSession httpsession = request.getSession();
				 httpsession.setAttribute("user", d);
				 httpsession.setAttribute("userType", "Dean");
				 response.sendRedirect("./userHome.jsp");
				 
			 }else{
				 request.setAttribute("errMsg", "Invalid Username or Password");
				 request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
}
