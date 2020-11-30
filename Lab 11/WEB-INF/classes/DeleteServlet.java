import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class DeleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		String name = req.getParameter("name");
		String result = "ERROR! Address Does Not Exist or Something Else";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab11", "root", "game");
			if(con != null){
				Statement st = con.createStatement();
				int cnt = st.executeUpdate("delete from AddrBook where name = '"+name+"'");
				if(cnt > 0)
					result = "Successfully Deleted!";
			}
			con.close();
		}
		catch(Exception ex){
			;
		}
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"Home.html\">");
		out.println("<h1 align=\"center\">"+result+"</h1>");
		out.println("<div align=\"center\"><input type=\"submit\" value=\"Home\" /></div>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}