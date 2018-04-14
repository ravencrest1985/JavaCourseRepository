package batchlet;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;

@Named
public class MyBatchlet extends AbstractBatchlet {

	public static final String START_DIR="D:/start";
	public static final String END_DIR="D:/end";
	
	public MyBatchlet() {
		System.out.println("Starting batchlet");
	}

	@Override
	public String process() throws Exception {
	
		try {
			Files.list(Paths.get(START_DIR)).forEach(path -> {
				try {
					System.out.println(path);
					Files.move(path, Paths.get(END_DIR,path.getFileName().toFile().getName()));
				}
				catch(IOException e) {
					throw new UncheckedIOException(e);
				}
				});
		}
		catch(UncheckedIOException e) {
			System.out.println("copy batchlet failed");
			return "MOVE_FAILED";
		}
		
		System.out.println("copy batchlet success");
		return "MOVE_SUCCESS";
	}

}
