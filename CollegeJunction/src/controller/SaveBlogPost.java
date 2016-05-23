package controller;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.BlogPost;
import entities.Research;
import hibernate.SessionFactoryBuilder;
import users.Dean;
import users.Director;

/**
 * Servlet implementation class SaveBlogPost
 */
@WebServlet("/SaveBlogPost")
public class SaveBlogPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveBlogPost() {
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
		
		try{
			String title = request.getParameter("title");
			String postContent = request.getParameter("post");
			
			Date d = new Date();
			
			BlogPost post = new BlogPost();
			post.setTitle(title);
			post.setPost(postContent);
			post.setDate(d);
			
			HttpSession s = request.getSession();
			if(s.getAttribute("userType").equals("Director")){
				post.setAuthorType("Director");
				post.setAuthor(((Director)s.getAttribute("user")).getName());
			}else if(s.getAttribute("userType").equals("Dean")){
				post.setAuthorType("Dean");
				post.setDepartment(((Dean)s.getAttribute("user")).getDepartment());
				post.setAuthor(((Dean)s.getAttribute("user")).getName());
			}
			SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx= null;
			try{
				tx = session.beginTransaction();
				session.save(post);
				tx.commit();
			}catch(RuntimeException e){
				e.printStackTrace();
				tx.rollback();
				request.setAttribute("errMsg", e.getMessage());
			}
			
			request.setAttribute("msg", "Content posted succesfully");
			request.setAttribute("post", post);
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("errMsg", e.getMessage());
			}
			
			request.getServletContext().getRequestDispatcher("/blog/AddPost1.jsp").forward(request, response);

	}

}
