package visit;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class VisitCounter {
	private AtomicInteger visitNumber;
	@PostConstruct
	public void init() {
		visitNumber = new AtomicInteger(0);
	}
	public int getVisitNumber() {
		return visitNumber.incrementAndGet();
	}
}
