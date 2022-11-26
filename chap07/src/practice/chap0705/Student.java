package practice.chap0705;

public class Student {
	private String name;
	private String department;
	private int id;
	private double avg;
	
	// 持失切 持失
	public Student(String name, String department, int id, double avg) { 
		this.name = name;
		this.department = department;
		this.id = id;
		this.avg = avg;
	}
	
	//getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	//toString 持失
	@Override
	public String toString() {
		return "Student [name=" + name + ", department=" + department + ", id=" + id + ", avg=" + avg + "]";
	}
}
