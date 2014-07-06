package challenge;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {


	private static final long serialVersionUID = -792151434053932911L;

@Override
protected void doGet(final HttpServletRequest req,
		final HttpServletResponse resp) throws ServletException,
		IOException {
	RequestDispatcher view = req.getRequestDispatcher("FirstHtml.html");
	view.forward(req, resp);
}
}
