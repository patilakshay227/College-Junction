package entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.mysql.jdbc.Blob;

@Entity
public class Ebooks extends ELearning {
	
	@Column(length= 10000000)
	private byte[] pdf;
	
	public byte[] getPdf() {
		return pdf;
	}

	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
	
}
