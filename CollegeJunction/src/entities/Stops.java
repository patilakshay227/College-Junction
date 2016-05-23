package entities;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stops {

	@Id @GeneratedValue
	private int temp;
	private int busNo;
	private String stopName;
	private Time time;

	public Stops(int busNo, String stopName, Time time) {
		super();
		this.stopName = stopName;
		this.time = time;
		this.busNo = busNo;
	}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public Stops() {

	}

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
