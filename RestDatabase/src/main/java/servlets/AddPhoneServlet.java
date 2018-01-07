package servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.PersonDao;


@WebServlet("/AddPhoneServlet")
public class AddPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Inject
	PersonDao ps;
 
    public AddPhoneServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String tempId=request.getParameter("id");
	String tempPhone=request.getParameter("phone");
	
	int id=Integer.parseInt(tempId);
	int phone= Integer.parseInt(tempPhone);
	
	ps.update(id, phone);
	
		
		
	}

}
