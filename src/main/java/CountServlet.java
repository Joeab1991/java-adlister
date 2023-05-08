import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class CountServlet extends HttpServlet {
	private int count = 0;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if (req.getParameter("reset") != null) {
			count = 0;
			out.println("<h1>The count has been reset!</h1>");
		} else {
			count++;
			out.println("<h1>The count is " + count + "!</h1>");
		}
	}

}
