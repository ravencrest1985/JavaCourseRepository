package impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import inter.Dao;
import model.Person;
import model.PhoneNumber;

public class PersonDao implements Dao {
	@PersistenceContext
	EntityManager em;
	@Inject
	UserTransaction utr;
	String creationMessage;
	@Override
	public void create(Person p) {
		try {
			utr.begin();
			em.persist(p);
			utr.commit();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@Override
	public String read(long id) {	
		TypedQuery<Person> createNamedQuery = em.createNamedQuery("findQueryPerson", Person.class);
		createNamedQuery.setParameter("id", id);	
		try {
			Person singleResult = createNamedQuery.getSingleResult();
			creationMessage = "User: " + singleResult.getName() + " found in database";
		} catch(Exception e) {
			creationMessage = "User was not found in database";
		}
		return creationMessage;
	}
	@Override
	public void update(long id, int number) {	
		
		try {
		utr.begin();
		Person p = em.find(Person.class, id);	
		List<PhoneNumber> phones = p.getPhones();
		//setting phone number
		PhoneNumber pn= new PhoneNumber();
		pn.setNumber(number);
		pn.setPerson(p);
		//setting user
		phones.add(pn);
		p.setPhones(phones);
		utr.commit();
		
		utr.begin();
		em.persist(pn);
		utr.commit();
			
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(long id) {
	}

}
