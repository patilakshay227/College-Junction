package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bus {

	@Id
	private int busNo;
	private String driverName;
	private String driverContactNo;

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverContactNo() {
		return driverContactNo;
	}

	public void setDriverContactNo(String driverContactNo) {
		this.driverContactNo = driverContactNo;
	}

}
