package servlets;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secure")
public class Secure extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Secure() {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Principal userPrincipal = request.getUserPrincipal();
		String name = userPrincipal.getName();
		response.getWriter().println("welcome: " + name);
	}
}