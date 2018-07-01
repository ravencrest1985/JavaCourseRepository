package interfaces;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface TaskRemote {	
	public void addTask(String task);
	public List<String> getTaskList();
	public void closeConnection();
}
