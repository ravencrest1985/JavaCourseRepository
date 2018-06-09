package chunk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;

@Named
public class CsvReader extends AbstractItemReader {
	BufferedReader rm;
	public static final String FILE_NAME = "D:/end/personData.csv";
	public void open(Serializable checkpoint) throws Exception {
		rm = new BufferedReader(
				//new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(FILE_NAME), "UTF-8"));
				new FileReader(FILE_NAME));
		rm.readLine();
	}
	@Override
	public Object readItem() throws Exception {
		String readLine = rm.readLine();
		System.out.println(readLine);
		return readLine != null ? readLine : null;
	}
	public void close() throws Exception {
		if(rm!=null)
			rm.close();
	}
}