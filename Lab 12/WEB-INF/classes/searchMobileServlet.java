import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class searchMobileServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		String companyName = req.getParameter("companyName");
		String model = req.getParameter("model");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Search Mobile Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"Home.html\">");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobileInfo", "root", "game");
			if(con != null){
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from mobileOutlet where companyName = '"+companyName+"' and model = '"+model+"'");
				Boolean b = false;
				while(rs.next()){
					if(!b){
						out.println("<table width=\"60%\" align=\"center\" border=\"1\">");
						out.println("<thead><th>Company Name</th><th>Model</th><th>Price</th></thead>");
						b = true;
					}
					out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>Rs."+rs.getString(3)+"</td></tr>");
				}
				if(!b)
					out.println("<h1 align=\"center\">ERROR! Mobile Not Found</h1>");
				else
					out.println("</table>");
			}
			con.close();
		}
		catch(Exception ex){
			;
		}
		out.println("<div align=\"center\"><input type=\"submit\" value=\"Home\" /></div>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}