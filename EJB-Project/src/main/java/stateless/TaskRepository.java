package stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Task;

@Stateless
public class TaskRepository {
	@PersistenceContext
	EntityManager em;
	public void addTask(Task task) {
		em.persist(task);
	}
	public void addRemove(Task task) {
		em.remove(task);
	}
		
	public List<Task> findAllTasks() {		
		Query createNamedQuery = em.createNamedQuery("Task.findAll");
		List<Task> resultList = createNamedQuery.getResultList();
		return resultList;	
	}	
}
