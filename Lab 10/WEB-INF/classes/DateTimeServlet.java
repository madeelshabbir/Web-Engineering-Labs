import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.Date;
import java.text.*;
public class DateTimeServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		DateFormat fmt = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome Servlet</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"black\">");
		out.println("<h1 align=\"center\" style=\"color: orange; font-size: 200px; margin-top: 50px; border: 5px dotted orange;\">"+fmt.format(new Date())+"</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}