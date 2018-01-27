package endpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user-agent")
@RequestScoped
public class HeaderInfo {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getUserAgent(@QueryParam("user-agent") String userAgent) {
		return Response.ok(userAgent).build();
	}
}
