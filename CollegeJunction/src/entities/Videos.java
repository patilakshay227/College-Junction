package entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Videos extends Skills {

	String caption;
	String fileName;
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	String link;
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
	
}
