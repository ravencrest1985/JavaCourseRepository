package chunk;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class CsvWriter extends AbstractItemWriter {
	@PersistenceContext
	private EntityManager em;
	
	public CsvWriter() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void writeItems(List<Object> items) throws Exception {
		items.stream().peek(System.out::println).forEach(em::persist);
	}
}
