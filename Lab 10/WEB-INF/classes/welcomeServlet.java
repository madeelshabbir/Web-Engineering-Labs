import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class welcomeServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome Servlet</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"black\">");
		out.println("<h1 align=\"center\" style=\"color: orange; font-size: 200px; margin-top: 200px; border: 5px dotted orange;\">Welcome</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}