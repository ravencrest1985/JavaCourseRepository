package servlets;

import java.io.IOException;
import java.security.Principal;

import javax.ejb.EJBAccessException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.SecureBean;

@WebServlet("/EjbServlet")
@ServletSecurity(httpMethodConstraints = @HttpMethodConstraint(value = "GET", rolesAllowed = { "admin", "user" }))
public class EjbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	SecureBean bean;

	public EjbServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Principal userPrincipal = request.getUserPrincipal();
		String name = userPrincipal.getName();
		response.getWriter().println("Hello user: " + name);
		try {
			String message = bean.getMessage();
			response.getWriter().println(message);
		} catch (EJBAccessException e) {
			response.getWriter().println("Sorry, you are not allowed to show secret message");
		}
	}
}
