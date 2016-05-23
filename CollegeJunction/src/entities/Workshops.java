package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Workshops {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String date;
	private String venue;
	private String details;
	private String regLastDate;
	private int regFee;
	
	
	public int getRegFee() {
		return regFee;
	}
	public void setRegFee(int regFee) {
		this.regFee = regFee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getRegLastDate() {
		return regLastDate;
	}
	public void setRegLastDate(String regLastDate) {
		this.regLastDate = regLastDate;
	}
	

}
