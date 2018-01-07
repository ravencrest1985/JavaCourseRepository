package endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Person;
import model.PhoneNumber;

@RequestScoped
@Path("/persons")
public class PersonEndpoint {
	@PersistenceUnit(name = "RestDatabase")
	EntityManagerFactory emf;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public List<Person> getPersons() {

		EntityManager createEntityManager = emf.createEntityManager();
		TypedQuery<Person> createQuery = createEntityManager.createNamedQuery("findQueryPersons", Person.class);
		List<Person> resultList = createQuery.getResultList();
		return resultList;
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@PathParam(value = "id") long id) {
		Person singleResult = null;
		EntityManager createEntityManager = emf.createEntityManager();
		TypedQuery<Person> createNamedQuery = createEntityManager.createNamedQuery("findQueryPerson", Person.class);
		createNamedQuery.setParameter("id", id);
		try {
			singleResult = createNamedQuery.getSingleResult();
		} catch (Exception e) {

			System.out.println("cant get single result");
		}
		return singleResult;
	}

	@Path("{id}/phones")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public List<PhoneNumber> getPhoneNumbers(@PathParam(value = "id") long id) {
		List<PhoneNumber> resultList = new ArrayList<>();
		EntityManager createEntityManager = emf.createEntityManager();
		String query="select p1 from PhoneNumber p1 where p1.person.id=:id";
		TypedQuery<PhoneNumber> createNamedQuery = createEntityManager.createQuery(query, PhoneNumber.class);
		createNamedQuery.setParameter("id", id);
		try {
			resultList = createNamedQuery.getResultList();
		} catch (Exception e) {
			System.out.println("Could not retrive phone list");
		}
		return resultList;
	}
	
	@Path("{id}/phones/{idPhone}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public PhoneNumber getPhoneNumber(@PathParam("id") long personId,@PathParam("idPhone") long idPhone ) {
		
		PhoneNumber phoneNumber = new PhoneNumber();
		EntityManager createEntityManager = emf.createEntityManager();
		String query="select p1 from PhoneNumber p1 where p1.person.id=:id and p1.id=:idPhone";
		TypedQuery<PhoneNumber> createNamedQuery = createEntityManager.createQuery(query, PhoneNumber.class);
		createNamedQuery.setParameter("id", personId);
		createNamedQuery.setParameter("idPhone", idPhone);
		try {
			phoneNumber = createNamedQuery.getSingleResult();
		} catch (Exception e) {
			System.out.println("Could not retrive phone list");
		}
		return  phoneNumber;
	}
	

}
