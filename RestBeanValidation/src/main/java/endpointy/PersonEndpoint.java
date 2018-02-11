package endpointy;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Person;

@RequestScoped
@Path("/Person")
public class PersonEndpoint {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerson(@Size(min = 1) @FormParam("name") String name, @Min(1) @FormParam("age") int tempAge) {
		boolean status = true;
		Person person = new Person();
		if (Optional.ofNullable(name).isPresent()) {
			System.out.println("name correct");
			person.setName(name);
		} else {
			System.out.println("name uncorrect");
			status = false;
		}
		if (tempAge > 0) {
			person.setAge(tempAge);
			System.out.println("age correct");
		} else {
			System.out.println("age uncorrect");
			status = false;
		}
		if (status) {
			System.out.println("good");
			return Response.ok(person).build();
		} else {
			System.out.println("failed");
			return Response.status(404).build();
		}
	}
}
