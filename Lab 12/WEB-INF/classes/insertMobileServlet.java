import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class insertMobileServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		String companyName = req.getParameter("companyName");
		String model = req.getParameter("model");
		int price = Integer.parseInt(req.getParameter("price"));
		String result = "ERROR! Something Went Wrong";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobileInfo", "root", "game");
			if(con != null){
				Statement st = con.createStatement();
				st.executeUpdate("insert into mobileOutlet(companyName, model, price) values('"+companyName+"', '"+model+"', "+price+")");
				result = "Successfully Added!";
			}
			con.close();
		}
		catch(Exception ex){
			result = "ERROR! Something Went Wrong";
		}
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert Mobile Servlet</title>");
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