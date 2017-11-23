package servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import email.MailService;
import email.ServiceMessage;

@WebServlet("/ReciveMessage")
public class ReciveMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReciveMessage() {
		super();
	}
	@Inject
	private MailService service;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	String userMessage = request.getParameter("userMessage");
	String userName = request.getParameter("userName");
	ServiceMessage message = new ServiceMessage(userMessage, userName);
	service.sendMessage(message);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
