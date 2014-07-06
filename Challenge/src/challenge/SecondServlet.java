package challenge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	private static final long serialVersionUID = 7494997688340012320L;

	
	private static final String INVALID_PARAMETER = "The pass is a number between 0 and 1000.\nThat's not a number between 0 and 100.";
	private static final String HINT_NO_PARAM = "Try sending a \"pass\" parameter.";
	private static final String FAIL_OUTPUT = "Nope!";
	private static final String SUCCESS_OUTPUT = "Success! Go to /asdfinuh for the next challenge!";
@Override
protected void doGet(final HttpServletRequest req,
		final HttpServletResponse resp) throws ServletException, IOException{
	resp.setContentType("text/plain; charset=utf-8");
	if(!req.getParameterMap().containsKey("pass")){
		resp.getWriter().println(HINT_NO_PARAM);
		return;
	}
	String pass =req.getParameter("pass");
	if (!isInteger(pass)&&isInRange(pass)){
		resp.getWriter().println(INVALID_PARAMETER);
	}
	
	if (pass.equals("473")){
		resp.getWriter().println(SUCCESS_OUTPUT);
	}
	else
		resp.getWriter().println(FAIL_OUTPUT);
}
private boolean isInRange(String pass) {
	int i=Integer.parseInt(pass);
	
	return (i>=0&&i<=1000);
}
private boolean isInteger(String pass) {
	try{
		Integer.parseInt(pass);
		return true;
	}
	catch(NumberFormatException e){
		return false;
	}
	
}
}
