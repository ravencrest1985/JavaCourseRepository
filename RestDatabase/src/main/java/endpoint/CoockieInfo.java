package endpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cookie-info")
@RequestScoped
public class CoockieInfo {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCookieInfo(@CookieParam("auth-token") String CookieInfo) {
		if (CookieInfo != null) {
			return Response.ok(CookieInfo).build();
		} else {
			return Response.status(404).build();
		}
	}
}
