package implementation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import interfaces.TaskRemote;

@Stateful
public class TaskRemoteImpl implements TaskRemote {
	private List<String> taskList;
	@PostConstruct
	private void init() {
		taskList = new ArrayList<>();
	}
	@Override
	public void addTask(String task) {
		taskList.add(task);
	}
	@Override
	public List<String> getTaskList() {
		return taskList;
	}
	@Remove
	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
	}
}
