package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.News;
import entities.Notices;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class DownloadNotice
 */
@WebServlet("/DownloadNotice")
public class DownloadNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadNotice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = null;
		
		try{
			tx= s.beginTransaction();
			Notices n = (Notices)s.get(Notices.class, id);
			tx.commit();
			byte[] pdf = n.getPdf();
			response.setHeader("Content-Disposition", "attachment; filename=\"" + n.getTitle() + ".pdf\"");
			response.setContentType("application/pdf");
			ServletOutputStream sos =  response.getOutputStream();
			sos.write(pdf);
			sos.flush();
			sos.close();
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			s.close();
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
