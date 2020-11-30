import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
class Page{
	private String fName;
	private String lName;
	private String email;
	private String password;
	private String gender;
	private Date dob;
	public Page(){
		this.fName = null;
		this.lName = null;
		this.email = null;
		this.password = null;
		this.gender = null;
		this.dob = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	private boolean verifyEmail(String s){
		boolean b = false;
		boolean c = false;
		for(int i = 0; i<s.length(); i++){
			if(!b && s.charAt(i) == '@')
				b = true;
			else if(b && s.charAt(i) == '@')
				return false;
			else if(b && s.charAt(i) == '.' && i != s.length() - 1)
				c = true;
		}
		if(!c)
			return false;
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab7", "root", "game");
			if(con != null){
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select count(*) from Cred where Email = '"+s+"';");
				if(rs.next()){
					if(rs.getInt(1) != 0){
						System.out.print("Email Already Exists or ");
						return false;
					}
				}
			}
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return true;
	}
	private boolean verifyDate(int d, int m, int y){
		switch(m){
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				if(d>31 || d<1)
					return false;
				break;
			case 2:
				if(y%4 == 0){
					if(d>29 || d<1)
						return false;
				}
				else if(d>28 || d<1){
					return false;
				}
				break;
			case 4: case 6: case 9: case 11:
				if(d>30 || d<1)
					return false;
				break;
			default:
				return false;
		}
		if(y>2020 || y<1000)
			return false;
		else if(y == 2020 && m > 4)
			return false;
		else if(y == 2020 && m == 4 && d > 10)
			return false;
		return true;
	}
	public void createAcccount(){
		Scanner in = new Scanner(System.in);
		System.out.println("============== Sign Up Page ==============");
		while(true){
			System.out.print("Enter First Name: ");
			this.fName = in.nextLine();
			if(this.fName.length() > 0)
				break;
			System.out.println("First Name can't be NULL!");
		}
		while(true){
			System.out.print("Enter Last Name: ");
			this.lName = in.nextLine();
			if(this.lName.length() > 0)
				break;
			System.out.println("Last Name can't be NULL!");
		}
		while(true){
			System.out.print("Enter Email: ");
			this.email = in.nextLine();
			if(this.verifyEmail(this.email))
				break;
			System.out.println("Invalid Email (@ and . are compulsary characters in an Email)!");
		}
		while(true){
			System.out.print("Enter Password: ");
			this.password = in.nextLine();
			if(this.password.length() < 1){
				System.out.println("Password can't be not NULL!");
				continue;
			}
			else if(this.password.length() < 8){
				System.out.println("Warning Password is weak!");
				boolean b = false;
				while(true){
					System.out.println("Do you want to re-enter? [y,n]");
					String t = in.nextLine();
					if(t.equals("y") || t.equals("Y"))
						b = true;
					else if(t.equals("n") || t.equals("N"))
						b = false;
					else
						continue;
					break;
				}
				if(b)
					continue;
			}
			break;
		}
		while(true){
			System.out.print("Enter Gender: ");
			this.gender = in.nextLine();
			if(this.gender.equals("Male") || this.gender.equals("male") || this.gender.equals("Female") || this.gender.equals("female") || this.gender.equals("other") || this.gender.equals("Other"))
				break;
			System.out.println("Invalid Gender (Male/male , Female/female or Other/other)!");
		}
		while(true){
			System.out.println("Enter Date of Birth:-");
			int d = 0, m =0,y= 0;
			while(true){
				try{
					System.out.print("Enter Day(1-31): ");
					d = in.nextInt();
					break;
				}
				catch(Exception ex){
					System.out.print("Enter Interger Value!");
					in.nextLine();
				}
			}
			while(true){
				try{
					System.out.print("Enter Month(1-12): ");
					m = in.nextInt();
					break;
				}
				catch(Exception ex){
					System.out.print("Enter Interger Value!");
					in.nextLine();
				}
			}
			while(true){
				try{
					System.out.print("Enter Year(e.g. 1998): ");
					y = in.nextInt();
					break;
				}
				catch(Exception ex){
					System.out.print("Enter Interger Value!");
					in.nextLine();
				}
			}
			if(this.verifyDate(d,m,y)){
				this.dob = Date.valueOf(y+"-"+m+"-"+d);
				break;
			}
			System.out.println("Invalid Date(That does not exists)!");
		}
		in.nextLine();
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab7", "root", "game");
			if(con != null){
				Statement st = con.createStatement();
				st.executeUpdate("insert into Cred(FName, LName, Email, Password, Gender, DOB) values('"+this.fName+"', '"+this.lName+"', '"+this.email+"', '"+this.password+"', '"+this.gender+"', '"+this.dob+"')");
				JOptionPane.showMessageDialog(null, "Account Sucessfully Created!");
			}
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	public boolean signIn(){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab7", "root", "game");
			if(con != null){
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select count(*) from Cred where Email = '"+JOptionPane.showInputDialog("Enter Email: ")+"' and Password = '"+JOptionPane.showInputDialog("Enter Password: ")+"';");
				if(rs.next()){
					if(rs.getInt(1) == 0){
						JOptionPane.showMessageDialog(null, "Invalid Credentials! (Email or Password is Invalid)");
						return false;
					}
					JOptionPane.showMessageDialog(null, "Successfully Sign-In");
					return true;
				}
			}
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return false;
	}
	public boolean updateProfile(){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab7", "root", "game");
			this.email = JOptionPane.showInputDialog("Enter Email whose Profile you want to update: ");
			if(con != null){
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select count(*) from Cred where Email = '"+this.email+"' and Password = '"+JOptionPane.showInputDialog("Enter Password for authentication: ")+"';");
				if(rs.next()){
					if(rs.getInt(1) == 0){
						JOptionPane.showMessageDialog(null, "Invalid Credentials! (Email or Password is Invalid)");
						return false;
					}
					JOptionPane.showMessageDialog(null, "To Enter New Data Press OK!");
				}
			}
			Scanner in = new Scanner(System.in);
			System.out.println("============== Update Profile Page ==============");
			while(true){
				System.out.print("Enter New First Name: ");
				this.fName = in.nextLine();
				if(this.fName.length() > 0)
					break;
				System.out.println("First Name can't be NULL!");
			}
			while(true){
				System.out.print("Enter New Last Name: ");
				this.lName = in.nextLine();
				if(this.lName.length() > 0)
					break;
				System.out.println("Last Name can't be NULL!");
			}
			while(true){
				System.out.print("Enter New Password: ");
				this.password = in.nextLine();
				if(this.password.length() < 1){
					System.out.println("Password can't be not NULL!");
					continue;
				}
				else if(this.password.length() < 8){
					System.out.println("Warning Password is weak!");
					boolean b = false;
					while(true){
						System.out.println("Do you want to re-enter? [y,n]");
						String t = in.nextLine();
						if(t.equals("y") || t.equals("Y"))
							b = true;
						else if(t.equals("n") || t.equals("N"))
							b = false;
						else
							continue;
						break;
					}
					if(b)
						continue;
				}
				break;
			}
			while(true){
				System.out.print("Enter New Gender: ");
				this.gender = in.nextLine();
				if(this.gender.equals("Male") || this.gender.equals("male") || this.gender.equals("Female") || this.gender.equals("female") || this.gender.equals("other") || this.gender.equals("Other"))
					break;
				System.out.println("Invalid Gender (Male/male , Female/female or Other/other)!");
			}
			while(true){
				System.out.println("Enter New Date of Birth:-");
				int d = 0, m =0,y= 0;
				while(true){
					try{
						System.out.print("Enter Day(1-31): ");
						d = in.nextInt();
						break;
					}
					catch(Exception ex){
						System.out.print("Enter Interger Value!");
						in.nextLine();
					}
				}
				while(true){
					try{
						System.out.print("Enter Month(1-12): ");
						m = in.nextInt();
						break;
					}
					catch(Exception ex){
						System.out.print("Enter Interger Value!");
						in.nextLine();
					}
				}
				while(true){
					try{
						System.out.print("Enter Year(e.g. 1998): ");
						y = in.nextInt();
						break;
					}
					catch(Exception ex){
						System.out.print("Enter Interger Value!");
						in.nextLine();
					}
				}
				if(this.verifyDate(d,m,y)){
					this.dob = Date.valueOf(y+"-"+m+"-"+d);
					break;
				}
				System.out.println("Invalid Date(That does not exists)!");
			}
			in.nextLine();	
			if(con != null){
				Statement st = con.createStatement();
				st.executeUpdate("update Cred set FName = '"+this.fName+"', LName = '"+this.lName+"', Password = '"+this.password+"', Gender = '"+this.gender+"', DOB = '"+this.dob+"' where Email = '"+this.email+"';");
			}
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
			return false;
		}
		return true;
	}
}
class Driver{
	public static void main(String[] arg){
		Page p = new Page();
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("======== Main Menu ========");
			System.out.println("1. Create Account");
			System.out.println("2. Sign In");
			System.out.println("3. Update Profile");
			System.out.println("4. Exit");
			System.out.print("Enter Option: ");
			try{
				switch(in.nextInt()){
				case 1:
					p.createAcccount();
					break;
				case 2:
					p.signIn();
					break;
				case 3:
					p.updateProfile();
					break;
				case 4:
					return;
				default:
					System.out.println("Enter Integer in range 1-4");
				}
			}
			catch(Exception ex){
				in.nextLine();
				System.out.println("Enter Integer Only");
			}
		}
	}
}