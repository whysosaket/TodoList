package GUI;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BufferReading {
	static ArrayList<String> tasks;
	public static void read() throws FileNotFoundException {

		tasks = new ArrayList<>();

		BufferedReader br= new BufferedReader(new FileReader(GUI.file));

		while(true) {
			try {
				String line= br.readLine();
				if(line==null||line.equals("")) break;
				tasks.add(line);

			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public static void print() {
		try {
			read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(String s: tasks) {
			System.out.println(s);
		}
	}

}
