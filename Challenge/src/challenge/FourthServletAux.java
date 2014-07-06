package challenge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FourthServletAux extends HttpServlet {
	private static final String NEED_USERNAME = "Use the textbox to enter a username.";
	private static final String TRICKY_USERNAME_MSG = "Hey! you're not supposed to use that username!";
	private static final String TRICKY_IP_MSG = "Hey! you're not supposed to user that IP!";

	@Override
	protected void doGet(final HttpServletRequest req,
			final HttpServletResponse resp) throws ServletException,
			IOException {
		resp.setContentType("text/plain; charset=utf-8");

		String message = buildMessage(req, resp);
		req.setAttribute("message", message);
		req.getRequestDispatcher(URLS.JSPPagesFolder+"fourthAux.jsp").forward(req, resp);
	}

	private String buildMessage(final HttpServletRequest req,
			final HttpServletResponse resp) throws ServletException,
			IOException {
		String ipAddress = req.getHeader("HTTP_X_FORWARDED_FOR");
		if (ipAddress == null) {
			ipAddress = req.getRemoteAddr();
		}

		String userName = req.getParameter("username");
		if (userName == null) {
			return NEED_USERNAME;
		}
		if (userName.equals(FourthServlet.userName)) {
			return TRICKY_USERNAME_MSG;
		}
		if (ipAddress.equals(FourthServlet.userIP)) {
			return TRICKY_IP_MSG;
		}
		return "For IP " + ipAddress + " and username " + userName
				+ " the code is " + generateCode(ipAddress, userName);
	}

	static String generateCode(String ipAddress, String userName) {
		return mixString(userName) + encodeIp(ipAddress);
	}

	private static String encodeIp(String ipAddress) {
		String[] segments = ipAddress.split("\\.");
		return invertSegment(segments[0]);
	}

	private static String invertSegment(String seg) {
		int iSeg = Integer.valueOf(seg);
		return "" + (iSeg ^ 255);
	}

	private static String mixString(String userName) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < userName.length(); i++) {
			char c = userName.charAt(i);
			c ^= 7;
			s.append(c);
		}
		return s.reverse().toString();
	}

	// public static class TestClass {
	// @Test
	// public void test0() {
	// System.out.println(generateCode(FourthServlet.userIP,
	// FourthServlet.userName));
	// }
	// }
}
