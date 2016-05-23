package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.News;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class NewsAdder
 */
@WebServlet("/NewsAdder")
public class NewsAdder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsAdder() {
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
		String news = request.getParameter("news");
		
		News n = new News();
		n.setNews(news);
		n.setUploadDate(new java.sql.Date(new Date().getTime()));
		try{
			SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(n);
				tx.commit();
				request.setAttribute("msg", "News Added Succesfully");
			} catch (RuntimeException ex) {
				ex.printStackTrace();
				tx.rollback();
				request.setAttribute("msg", ex.getCause().toString());
			}finally{
				session.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msg", e.getCause().toString());
		}
		request.getServletContext().getRequestDispatcher("/admin/viewNews.jsp").forward(request, response);
	}

}
