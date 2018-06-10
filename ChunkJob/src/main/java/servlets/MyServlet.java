package servlets;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    
 
    public MyServlet() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		long start = jobOperator.start("copyJob", new Properties());
		
		 try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } 
		 JobExecution jobExecution = jobOperator.getJobExecution(start);
		 printExecutionTime(jobExecution);
		 String exitStatus = jobExecution.getExitStatus();	
		 System.out.println("job exit status: "+exitStatus);
		 response.getWriter().println("copy job started with id: "+start);
	}
	private void printExecutionTime(JobExecution execution) {	
		Date startDate = execution.getStartTime();
		Date endDate = execution.getEndTime();
		Instant startEpoch = Instant.ofEpochMilli(startDate.getTime());
		Instant endEpoch = Instant.ofEpochMilli(endDate.getTime());
		Duration duration = Duration.between(startEpoch, endEpoch);
		System.out.println(duration.getNano());
	}
}
