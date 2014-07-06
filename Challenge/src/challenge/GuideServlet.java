package challenge;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuideServlet extends HttpServlet {
	private static final String GUIDES = "Guides/";
	private Map<String,String> urlToLastFileMap = new TreeMap<String,String>();
	@Override
	protected void doGet(final HttpServletRequest req,
			final HttpServletResponse resp) throws ServletException, IOException{
		setUp();
		String nextURL =req.getParameter("nextURL");
		if (nextURL==null||nextURL.isEmpty()){
			req.getRequestDispatcher(GUIDES+"GuideGuide.html").forward(req, resp);
			return;
		}
		if(nextURL.startsWith("/"))
			nextURL=nextURL.substring(1, nextURL.length());
		RequestDispatcher view = req.getRequestDispatcher(urlToLastFileMap.get(nextURL));
		view.forward(req, resp);
	}
	private void setUp(){
		for (String url:URLS.URLS){
			urlToLastFileMap.put(url, GUIDES+"DefaultGuide.html");
		}
		urlToLastFileMap.put("aaa", GUIDES+"GuideGuide.html");
		urlToLastFileMap.put(URLS.URLS[1], GUIDES+"FirstGuide.html");
		
	}
	
}
