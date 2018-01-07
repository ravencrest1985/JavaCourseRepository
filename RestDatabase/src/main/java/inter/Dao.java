package inter;

import model.Person;

public interface Dao {

	public void create(Person p);

	public String read(long id);

	public void update(long id, int number);

	public void delete(long id);

}
