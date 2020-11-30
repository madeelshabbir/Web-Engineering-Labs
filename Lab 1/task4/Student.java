import javax.swing.*;
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
		while(true){
			try{
				this.studentName = JOptionPane.showInputDialog("Enter Student Name: ");
				break;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Invalid Input");		
			}
		}
		while(true){
			try{
				this.rollNo = JOptionPane.showInputDialog("Enter Roll No: ");
				break;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Invalid Input");		
			}
		}
		while(true){
			try{
				this.cgpa = Double.parseDouble(JOptionPane.showInputDialog("Enter CGPA: "));
				break;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Invalid Input");		
			}
		}			
	}
	public void Output(){
		JOptionPane.showMessageDialog(null, "Student Name: "+studentName);
		JOptionPane.showMessageDialog(null, "Roll No: "+rollNo);
		JOptionPane.showMessageDialog(null, "CGPA: "+cgpa);			
	}
}