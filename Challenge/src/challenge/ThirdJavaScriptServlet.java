package challenge;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ThirdJavaScriptServlet extends HttpServlet {
	private static final long serialVersionUID = 7860226556821198158L;
	   @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/javascript");
			RequestDispatcher view = request.getRequestDispatcher("third.js");
			view.forward(request, response);
	    }
}
