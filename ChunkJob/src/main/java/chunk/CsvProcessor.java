package chunk;

import java.util.StringTokenizer;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class CsvProcessor implements ItemProcessor {
	@Override
	public Object processItem(Object item) throws Exception {
		String data = (String) item;
		UserData createUser = createUser(data);
		return createUser;
	}
	private UserData createUser(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		UserData user = new UserData();
		user.setFirstName(st.nextToken());
		user.setLastName(st.nextToken());
		user.setEmail(st.nextToken());
		user.setGender(st.nextToken());
		user.setCompany(st.nextToken());
		user.setCountry(st.nextToken());
		return user;
	}
}