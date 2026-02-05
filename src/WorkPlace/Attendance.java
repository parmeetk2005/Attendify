package WorkPlace;

import java.io.Serializable;

public class Attendance implements Serializable {
	public int attended;
	public int dilivered;
	public float totalAttendance;
	
	public Attendance() {
		this.attended = 0;
		this.dilivered = 0;
		this.totalAttendance = 0f;
	}
}