package entities;

import javax.persistence.*;

@Entity
public class Poetry extends Skills {
	
	private String poem;
	
	public String getPoem() {
		return poem;
	}

	public void setPoem(String poem) {
		this.poem = poem;
	}
	
}
