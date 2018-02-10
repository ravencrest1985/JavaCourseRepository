package servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;
import model.PersonRepository;


@WebServlet("/AddPersonServlet")
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	PersonRepository personRepository;


    public AddPersonServlet() {
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("name");
		String tempAge=request.getParameter("age");
		String pesel=request.getParameter("pesel");
		
		int age=Integer.parseInt(tempAge);
		
		Person person= new Person();
		
		person.setName(name);
		person.setAge(age);
		person.setPesel(pesel);
		
		personRepository.addPerson(person);
		
	}

}
