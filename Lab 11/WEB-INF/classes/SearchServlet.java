import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class SearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		String name = req.getParameter("name");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"Home.html\">");
		out.println("<table width=\"60%\" align=\"center\" border=\"1\">");
		out.println("<thead><th>Name</th><th>Address</th><th>Phone Number</th></thead>");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab11", "root", "game");
			if(con != null){
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from AddrBook where name = '"+name+"'");
				while(rs.next()){
					out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
				}
			}
			con.close();
		}
		catch(Exception ex){
			;
		}
		out.println("</table>");
		out.println("<div align=\"center\"><input type=\"submit\" value=\"Home\" /></div>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}