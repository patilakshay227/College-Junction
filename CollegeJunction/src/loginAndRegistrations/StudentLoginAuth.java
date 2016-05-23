package loginAndRegistrations;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.SessionFactoryBuilder;
import users.Student;

/**
 * Servlet implementation class StudentLoginAuth
 */
@WebServlet("/StudentLoginAuth")
public class StudentLoginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginAuth() {
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
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		 try{
			
			 SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			 Session session = sf.openSession();
			 session.beginTransaction();
			 String hql = "From Student where email = :email and password = :password";
			 Query query = session.createQuery(hql);
			 query.setString("email", email);
			 query.setString("password", password);
			 Student s =  (Student) query.uniqueResult();
			 if(s!=null){
				 HttpSession httpsession = request.getSession();
				 httpsession.setAttribute("user", s);
				 httpsession.setAttribute("userType", "Student");
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
