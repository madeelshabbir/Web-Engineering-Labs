import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class ShowPersonServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PersonInfo person = (PersonInfo)req.getAttribute("sObj");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Show Person</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"SearchPerson.html\">");
		if(person != null){
			out.println("<table width=\"60%\" align=\"center\" border=\"1\">");
			out.println("<thead><th>Name</th><th>Address</th><th>Phone Number</th></thead>");
			out.println("<tr><td>"+person.getName()+"</td><td>"+person.getAddress()+"</td><td>"+person.getPhoneNum()+"</td></tr>");
			out.println("</table>");
		}
		else
			out.println("<h1 align=\"center\">Person not found!</h1>");
		out.println("<div align=\"center\"><input type=\"submit\" value=\"Home\" /></div>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}