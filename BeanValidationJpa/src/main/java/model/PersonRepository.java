package model;

import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;


public class PersonRepository {

	@PersistenceContext
	EntityManager em;
	@Inject
	UserTransaction utx;

	public void addPerson(Person person) {

		try {
			utx.begin();
			em.persist(person);
			utx.commit();
			
		} catch (ConstraintViolationException ex) {
			Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
			for (ConstraintViolation<?> tmp : constraintViolations) {
				System.out.println("invalid value: " + tmp.getInvalidValue());
				System.out.println("Message: " + tmp.getMessage());
				System.out.println("PropertyPath: " + tmp.getPropertyPath());
				try {
					utx.rollback();
				} catch (IllegalStateException | SecurityException | SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
}
