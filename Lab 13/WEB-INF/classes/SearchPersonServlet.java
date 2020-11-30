import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class SearchPersonServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		req.setAttribute("sObj", PersonDAO.searchPerson(req.getParameter("name")));
		RequestDispatcher reqDispatcher = req.getRequestDispatcher("ShowPersonServlet");
		reqDispatcher.forward(req, res);
	}
}