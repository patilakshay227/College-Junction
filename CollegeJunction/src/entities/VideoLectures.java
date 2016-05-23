package entities;

import javax.persistence.Entity;

@Entity
public class VideoLectures extends ELearning {
	
	private String link;
	private String description;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
