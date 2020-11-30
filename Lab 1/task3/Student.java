import java.util.*;
public class Student{
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
	public String getStudentName(){
		return this.studentName;
	}
	public String getRollNo(){
		return this.rollNo;
	}
	public double getCgpa(){
		return this.cgpa;	
	}
	public void setStudentName(String n){
		this.studentName = n;
	}
	public void set(String r){
		this.rollNo = r;
	}
	public void setGgpa(double c){
		this.cgpa = c;
	}
	public void Input(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Student Name: ");
		this.studentName = in.nextLine();
		System.out.print("Enter Roll No: ");
		this.rollNo = in.nextLine();
		System.out.print("Enter CGPA: ");
		this.cgpa = in.nextDouble();
		in.close();			
	}
	public void Output(){
		System.out.println("Student Name: "+studentName);
		System.out.println("Roll No: "+rollNo);
		System.out.println("CGPA: "+cgpa);			
	}
}