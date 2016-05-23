package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Ebooks;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class EbookSeachEngine
 */
@WebServlet("/EbookSearchEngine")
public class EbookSearchEngine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EbookSearchEngine() {
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
		
		List<Ebooks> list = null;
		String searchType = request.getParameter("searchType");
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		try{
			
			switch(searchType){
			case "name":
				String name = request.getParameter("name");
				String hql = "From Ebooks where title like '%"+name+"%'";
				list = session.createQuery(hql).list();
				break;
			case "department" : 
				String department = request.getParameter("department");
				hql = "From Ebooks where department = :dept";
				list = session.createQuery(hql).setString("dept", department).list();
				break;
			case "year":
				byte year = Byte.parseByte(request.getParameter("year"));
				hql = "From Ebooks where year = :year";
				list = session.createQuery(hql).setByte("year",year).list();
				break;
			}
			request.setAttribute("list", list);
			request.getServletContext().getRequestDispatcher("/searchedEbooks.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
