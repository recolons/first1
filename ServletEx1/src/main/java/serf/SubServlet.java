package serf;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SubServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Welcome to the sub servlet!");
		System.out.println("Welcome to the Sub Servlet!");
		
		// The ServletConfig w/ the 'Pokemon' name is not present in this Servlet.
		String configstring = this.getInitParameter("Pokemon");
		System.out.println(configstring);		// prints out null
		
		ServletContext sconxt = this.getServletContext();
		String contextstring = sconxt.getInitParameter("SportsTeam");
		System.out.println(contextstring);
		
		HttpSession sess = request.getSession();
		System.out.println(sess.getId());
		sess.setMaxInactiveInterval(3600);	// creates a new session and prints out a new id (prev line)
		
		sess.setAttribute("user", "{'name':'Ryan','email':'ryan@email.com'}");
		System.out.println(sess.getAttribute("user"));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
