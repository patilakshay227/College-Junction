package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;


@Entity
public class Photography extends Skills {
		
	private String caption;
	
	@Column(length= 10485760)
	@Lob
	@Basic(fetch= FetchType.LAZY)
	private byte[] photo;
	
	
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	
}
