package challenge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FourthServlet extends HttpServlet {
	private static final String CODE = "code";
	static final String userName = "Alice";
	static final String userIP = "107.149.11.45";
	private static final String tips = "In this exercise, you're trying to find out the credentials of a certain user.\n" +
			"You know the username is "+userName+", and that it was logged in from "+userIP+"\n" +
			"To get to the next link, you must enter the code that Alice used.\n" +
			"Fortunately, you can use the following url to try out codes: /onhpuhoin2\n" +
			"Good luck cracking!\n" +
			"When you have a guess at the code, pass it as an \"code\" parameter.";
	private static final String nextURL = "Congratulations! The next link is " +
			"<a href=\"../fdsuiogre\">here</a>.";
	private static final String BAD_ANSWER = "Nope! wrong code.";

	@Override
	protected void doGet(final HttpServletRequest req,
			final HttpServletResponse resp) throws ServletException,
			IOException {
		resp.setContentType("text/plain; charset=utf-8");
		String message;
		if (!req.getParameterMap().containsKey(CODE)) {
			message = tips;
		}
		String code = req.getParameter(CODE);
		if (verifyCode(code)) {
			message=nextURL;
		} else {
			message=BAD_ANSWER;
		}
		req.setAttribute("message", message);
		req.getRequestDispatcher(URLS.JSPPagesFolder+"fourth.jsp").forward(req, resp);
	}
	

	public static boolean verifyCode(String code2) {
		//Currently bdnkF148
		return FourthServletAux.generateCode(userIP, userName).equals(code2);
	}
}
