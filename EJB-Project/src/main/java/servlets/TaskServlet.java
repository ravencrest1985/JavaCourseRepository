package servlets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Task;
import stateless.TaskRepository;


@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Inject
	TaskRepository taskRepo;

    public TaskServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String name=request.getParameter("name");
	String description=request.getParameter("description");
	Task task= new Task();
	task.setDescription(description);
	task.setName(name);
	taskRepo.addTask(task);
	List findAllTasks = taskRepo.findAllTasks();
	request.setAttribute("list", findAllTasks);
	request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
