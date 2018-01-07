package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.PersonDao;
import impl.PhoneDaoImpl;
import model.Person;
import model.PhoneNumber;


@WebServlet("/ServletAddPerson")
public class ServletAddPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	PersonDao ps;
	
	@Inject
	PhoneDaoImpl phoneDaoImpl;
	
	String message;
	
    public ServletAddPerson() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name= request.getParameter("name");
		String tempAge=request.getParameter("age");
		int age=Integer.parseInt(tempAge);
		String tempNumber=request.getParameter("number");
		int number=Integer.parseInt(tempNumber);
		Person p= new Person();
		//setting phone number
		List<PhoneNumber>phoneNumbersList = new ArrayList<>();
		PhoneNumber phoneNumber= new PhoneNumber();
		phoneNumber.setNumber(number);
		phoneNumber.setPerson(p);
		phoneNumbersList.add(phoneNumber);
		//setting user.
		p.setName(name);
		p.setAge(age);
		p.setPhones(phoneNumbersList);
		ps.create(p);
		phoneDaoImpl.create(phoneNumber);
		message=ps.read(p.getId());
		request.setAttribute("message", message);
		request.getRequestDispatcher("result.jsp").include(request, response);
	}

}
