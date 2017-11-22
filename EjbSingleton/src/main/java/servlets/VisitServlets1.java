package servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visit.VisitCounter;

/**
 * Servlet implementation class VisitServlets1
 */
@WebServlet("/VisitServlets1")
public class VisitServlets1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private VisitCounter counter;
	
    public VisitServlets1() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	System.out.println("counter is:" +counter.getVisitNumber());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
