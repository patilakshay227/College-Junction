package entities;

import javax.persistence.Entity;

@Entity
public class MotivationalThought extends Skills {

	private String thought;

	public String getThought() {
		return thought;
	}

	public void setThought(String thought) {
		this.thought = thought;
	}
	
	
}
