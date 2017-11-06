package jobServlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobRepoistory.JobRepo;
import table.Job;

@WebServlet("/JobServletAdd")
public class JobServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private JobRepo jobRepo;

	public JobServletAdd() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = "";
		String job_name = request.getParameter("job_name");
		String job_desc = request.getParameter("job_desc");
		
		System.out.println("1 :"+job_name);
		System.out.println("2 :"+job_desc);
		

		// Adding job to database
		if (job_name != null && !job_name.isEmpty()  && job_desc != null && !job_desc.isEmpty()) {
			Job job = new Job();
			job.setName(job_name);
			job.setDesc(job_desc);
			jobRepo.addJob(job);
			//Try to find job in database.
			Job findAddedJob = jobRepo.findAddedJob(job);
			if (findAddedJob != null) {
				message = "found job: " + findAddedJob.getName();
			//job not found.
			} else {

				message = "didnt found job in database";
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
		// If user didn't specified job name or job desc.
		else {
			message = "job name or job desc is empty, cannot create job";
			System.out.print(message);
			request.setAttribute("message", message);
			request.getRequestDispatcher("result.jsp").include(request, response);
		}

	}

}
