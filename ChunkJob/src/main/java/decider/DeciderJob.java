package decider;

import java.io.File;

import javax.batch.api.Decider;
import javax.batch.runtime.StepExecution;
import javax.inject.Named;

import batchlet.MyBatchlet;

@Named
public class DeciderJob implements Decider {

	public DeciderJob() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String decide(StepExecution[] tablica) throws Exception {
		File file = new File(MyBatchlet.END_DIR);
		if (file.list().length == 0) {
			System.out.println("NO_FILES");
			return "NO_FILES";
		} else {
			System.out.println("FILES_EXIST");
			return "FILES_EXIST";
		}
	}
}
