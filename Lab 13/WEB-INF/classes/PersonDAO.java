import java.sql.*;
public class PersonDAO{
	public static PersonInfo searchPerson(String name){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBook", "root", "game");
			if(con != null){
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from Person where name = '"+name+"'");
				while(rs.next()){
					return new PersonInfo(rs.getString(1),rs.getString(2),rs.getString(3));
				}
				return null;
			}
			con.close();
		}
		catch(Exception ex){
			;
		}
		return null;
	}
}