package FileUpload;

import javax.servlet.http.Part;

public class FileUploadHelper {
	
	public static String getSubmittedFileName(Part part){
		for(String cd: part.getHeader("content-disposition").split(";")){
			if(cd.trim().startsWith("filename")){
				String fileName = cd.substring(cd.indexOf("=")+1).trim().replace("\"","");
				return fileName.substring(fileName.lastIndexOf('/')+1).substring(fileName.lastIndexOf('\\')+1);
			}
		}
		return null;
	}
}
