package fileHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputWrite {
	public static void main(String[] args) throws IOException {
		OutputStream os = System.out;
//		os.write(😒); // range exceeded
		System.out.println();
		
		/*
		try(OutputStreamWriter osw = new OutputStreamWriter(System.out)){
			osw.write("hello world");
			osw.write(97);
			osw.write('a');
			osw.write('\n');
			char[] arr = "hello world".toCharArray();
			osw.write(arr);
//			osw.write(😍);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		*/
		
		try(FileWriter fw =new FileWriter("src/fileHandling/note.txt", true)) {
			fw.write("hello sagar");
			fw.write(10);
			fw.write("hello world");
			fw.write('\n');
			fw.write("en madthidiya");
			fw.append("check");
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		try(BufferedWriter fw = new BufferedWriter(new FileWriter("src/fileHandling/note.txt", true))){
//			fw.write("hello sagar");
//			fw.write(10);
//			fw.write("hello world");
//			fw.write('\n');
//			fw.write("en madthidiya");
			fw.write("check");
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
