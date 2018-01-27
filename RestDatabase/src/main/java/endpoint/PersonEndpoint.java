package endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Person;
import model.PhoneNumber;

@RequestScoped
@Path("/persons")
public class PersonEndpoint {
	@PersistenceUnit(name = "RestDatabase")
	EntityManagerFactory emf;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPersons() {

		EntityManager createEntityManager = emf.createEntityManager();
		TypedQuery<Person> createQuery = createEntityManager.createNamedQuery("findQueryPersons", Person.class);
		List<Person> resultList = createQuery.getResultList();
		if (resultList == null || resultList.isEmpty()) {
			return Response.status(404).build();
		}
		return Response.ok(resultList).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void testSavingPerson(Person person) {

		System.out.println("Pobrany obiekt ma id: " + person.getId());
		System.out.println("Pobrany obiekt ma wiek: " + person.getAge());
		System.out.println("Pobrany obiekt ma imie: " + person.getName());

	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerson(@PathParam(value = "id") long id) {
		Person singleResult = null;
		EntityManager createEntityManager = emf.createEntityManager();
		TypedQuery<Person> createNamedQuery = createEntityManager.createNamedQuery("findQueryPerson", Person.class);
		createNamedQuery.setParameter("id", id);
		try {
			singleResult = createNamedQuery.getSingleResult();
		} catch (Exception e) {

			System.out.println("cant get single result");
			return Response.status(404).build();

		}
		return Response.ok(singleResult).build();
	}

	@Path("{id}/phones")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPhoneNumbers(@PathParam(value = "id") long id) {
		List<PhoneNumber> resultList = new ArrayList<>();
		EntityManager createEntityManager = emf.createEntityManager();
		String query = "select p1 from PhoneNumber p1 where p1.person.id=:id";
		TypedQuery<PhoneNumber> createNamedQuery = createEntityManager.createQuery(query, PhoneNumber.class);
		createNamedQuery.setParameter("id", id);
		try {
			resultList = createNamedQuery.getResultList();
		} catch (Exception e) {
			System.out.println("Could not retrive phone list");
			return Response.status(404).build();
		}
		return Response.ok(resultList).build();
	}

	@Path("{id}/phones/{idPhone}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPhoneNumber(@PathParam("id") long personId, @PathParam("idPhone") long idPhone) {

		PhoneNumber phoneNumber = new PhoneNumber();
		EntityManager createEntityManager = emf.createEntityManager();
		String query = "select p1 from PhoneNumber p1 where p1.person.id=:id and p1.id=:idPhone";
		TypedQuery<PhoneNumber> createNamedQuery = createEntityManager.createQuery(query, PhoneNumber.class);
		createNamedQuery.setParameter("id", personId);
		createNamedQuery.setParameter("idPhone", idPhone);
		try {
			phoneNumber = createNamedQuery.getSingleResult();
		} catch (Exception e) {
			System.out.println("Could not retrive phone list");
			return Response.status(404).build();
		}
		return Response.ok(phoneNumber).build();
	}

}
