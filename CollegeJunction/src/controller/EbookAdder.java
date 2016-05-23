package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Ebooks;
import entities.Notices;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class EbookAdder
 */
@MultipartConfig
@WebServlet("/EbookAdder")
public class EbookAdder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EbookAdder() {
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
		
		String title = request.getParameter("title");
		byte year = Byte.parseByte(request.getParameter("year"));
		String department = request.getParameter("department");
		String uploader = "akshaydapora@gmail.com";
		Part filePart = request.getPart("pdfFile");
		InputStream is = filePart.getInputStream();
		byte[] pdf = new byte[(int)filePart.getSize()];
		while(is.read(pdf)!=-1){
			
		}
		Ebooks e = new Ebooks();
		e.setTitle(title);
		e.setPdf(pdf);
		e.setUploader(uploader);
		e.setYear(year);
		e.setDepartment(department);
		
		try{
			SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(e);
				tx.commit();
				request.setAttribute("msg", "Ebook Added Succesfully");
			} catch (RuntimeException ex) {
				ex.printStackTrace();
				tx.rollback();
				request.setAttribute("msg", ex.getCause().toString());
			}finally{
				session.close();
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("msg", ex.getCause().toString());
		}
		
		response.sendRedirect("./myEbooks.jsp");
	}

}
