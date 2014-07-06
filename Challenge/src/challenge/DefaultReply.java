package challenge;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class DefaultReply {
	public static void replyMonkeys(HttpServletResponse resp) throws IOException{

		resp.setContentType("text/plain; charset=utf-8");
		 resp.getWriter().println("Sorry, not available yet.");
		 resp.getWriter().println("But hey, monkeys are working on it, so it'll be up soon.");
	}
}
