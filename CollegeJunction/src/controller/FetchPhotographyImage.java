package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Photography;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class FetchPhotographyImage
 */
@WebServlet("/FetchPhotographyImage")
public class FetchPhotographyImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchPhotographyImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
		long id =Long.parseLong(request.getParameter("id"));
		response.setContentType("image/png/jpeg");
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Photography pg =   (Photography)session.get(Photography.class, id);
		byte[] b = pg.getPhoto();
		response.getOutputStream().write(b);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
