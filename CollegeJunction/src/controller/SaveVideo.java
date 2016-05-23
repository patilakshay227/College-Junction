package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import FileUpload.FileUploadHelper;
import entities.Videos;
import hibernate.SessionFactoryBuilder;

/**
 * Servlet implementation class SaveVideo
 */
@MultipartConfig
@WebServlet("/SaveVideo")
public class SaveVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String path = "F:/Mars Workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/CollegeJunction/videos";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveVideo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.setContentType("text/html");
			String title = request.getParameter("title");
			String caption = request.getParameter("caption");
			Part filePart = request.getPart("video");
			byte[] video = new byte[(int)filePart.getSize()];
			InputStream is = filePart.getInputStream();
			while(is.read(video)!=-1){
				
			}
				
			Videos vd = new Videos();
			
			
			vd.setTitle(title);
			vd.setCaption(caption);
			vd.setUploadDate(new Date(new java.util.Date().getTime()));
			vd.setUploadTime(new Time(new java.util.Date().getTime()));
			String fileName = FileUploadHelper.getSubmittedFileName(filePart);
			String videoName = new Random().nextInt(1000)+vd.getTitle() + fileName.substring(fileName.lastIndexOf('.')) ;
			
			File f = new File(path+File.separator+videoName );
			if(!f.exists()){
				f.createNewFile();
			}
			vd.setFileName(videoName);
			vd.setLink("http://localhost:8080/CollegeJunction/videos/"+videoName);
			
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(video);
			fos.close();
			
			SessionFactory sf = SessionFactoryBuilder.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(vd);
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errMsg", e.getMessage());
				tx.rollback();
			} finally {
				session.close();
			}
			
			request.setAttribute("msg", "Your content uploaded succesfully :)");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
		}
		request.getServletContext().getRequestDispatcher("/AddSkillSuccess.jsp").forward(request, response);
		} 
}

