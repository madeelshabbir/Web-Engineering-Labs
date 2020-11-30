interface StudentData{
	void setName(String s);
	void setRollNumber(String s);
	void setCGPA(double d);
	String getName();
	String getRollNumber();
	double getCGPA();
	void display();
}
class Student implements StudentData{
	private String studentName;
	private String rollNo;
	private double cgpa;
	Student(){
		this(null, null, 0.0);
	}
	Student(String n, String r, double c){
		this.studentName = n;
		this.rollNo = r;
		this.cgpa = c;
	}
	Student(Student stu){
		this(stu.studentName, stu.rollNo, stu.cgpa);	
	}
	public String getName(){
		return this.studentName;
	}
	public String getRollNumber(){
		return this.rollNo;
	}
	public double getCGPA(){
		return this.cgpa;	
	}
	public void setName(String n){
		this.studentName = n;
	}
	public void setRollNumber(String r){
		this.rollNo = r;
	}
	public void setCGPA(double c){
		this.cgpa = c;
	}
	public void display(){
		System.out.println("Student Name: "+studentName);
		System.out.println("Roll No: "+rollNo);
		System.out.println("CGPA: "+cgpa);
	}
}