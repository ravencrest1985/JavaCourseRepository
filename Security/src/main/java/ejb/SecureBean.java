package ejb;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

@Stateless
@RolesAllowed("admin")
public class SecureBean {

	public SecureBean() {
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return "Secured Message no. " + System.currentTimeMillis();	
	}	
}