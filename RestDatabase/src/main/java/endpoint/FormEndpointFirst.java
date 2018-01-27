package endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Person;
import model.PhoneNumber;

@RequestScoped
@Path("/FormEndpointFirst")
public class FormEndpointFirst {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void getFromData(@FormParam("name") String name, @FormParam("age") int age,
			@FormParam("number") int number) {
		Person person = new Person();
		if (name != null && age != 0 && number != 0) {
			person.setName(name);
			person.setAge(age);
			PhoneNumber phoneNumber = new PhoneNumber();
			phoneNumber.setNumber(number);
			List<PhoneNumber> phoneList = new ArrayList<>();
			phoneList.add(phoneNumber);
			person.setPhones(phoneList);
			//return Response.ok(person).build();
			System.out.println("name: "+person.getName());
			System.out.println("age: "+person.getAge());
			System.out.println("phones: "+person.getPhones());
		} else {
			//return Response.status(404).build();
		}
	}
}
