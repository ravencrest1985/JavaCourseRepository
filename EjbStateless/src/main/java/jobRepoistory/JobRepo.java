package jobRepoistory;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import table.Job;

@Stateless
public class JobRepo {

	@PersistenceContext
	EntityManager em;

	public void addJob(Job job) {
		em.persist(job);
	}

	public void removeJob(Job job) {
		em.remove(job);
	}

	public List<Job> FindAllJobs() {

		TypedQuery<Job> createNamedQuery = em.createNamedQuery("findAllJobs", Job.class);
		List<Job> resultList = createNamedQuery.getResultList();
		return resultList;

	}
	public Job findAddedJob(Job job) {
		TypedQuery<Job> createNamedQuery = em.createNamedQuery("findJob", Job.class);
		createNamedQuery.setParameter("jobName", job.getName());
		Job singleResult = createNamedQuery.getSingleResult();
		return singleResult;
	}
}
