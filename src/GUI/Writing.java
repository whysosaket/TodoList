package GUI;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Writing {

	public static void write() throws IOException {
		//adding all the tasks
		/*
		 * try { BufferReading.read(); } catch (FileNotFoundException e) { //
		 * Auto-generated catch block e.printStackTrace(); }
		 *
		 * Scanner sc= new Scanner(System.in);
		 *
		 * while(true) { String line=""; line+=sc.nextLine();
		 * if(line.equals("break"))break; BufferReading.tasks.add(line); } sc.close();
		 */

		BufferedWriter bw= new BufferedWriter(new FileWriter(GUI.file));
		for(int i=0;i<BufferReading.tasks.size();i++) {
			String line;
			line=BufferReading.tasks.get(i);
			bw.write(line);
			bw.newLine();
		}
		bw.close();
	}

}
