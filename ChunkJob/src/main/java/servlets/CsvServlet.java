package servlets;

import java.io.IOException;
import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CsvServlet
 */
@WebServlet("/CsvServlet")
public class CsvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CsvServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		long jobId=jobOperator.start("csvToDatabase", new Properties());
		response.getWriter().append("CSV job started with id: " + jobId);
		
	}

}
