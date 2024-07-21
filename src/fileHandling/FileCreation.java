package fileHandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create
			try {
				File fo = new File("src/fileHandling/new-file.txt");
				fo.createNewFile();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		// write in the file
		  try {
			 FileWriter fw = new FileWriter("src/fileHandling/new-file.txt") ;
			 fw.write("नैनं छिद्रन्ति शस्त्राणि नैनं दहति पावक:।\r\n"
			 		+ "\r\n"
			 		+ "\r\n"
			 		+ "न चैनं क्लेदयन्त्यापो न शोषयति मारुत॥");
			 fw.close();
		  } catch(IOException e) {
			  System.out.println(e.getMessage());
		  }
		 
		// reading from the file
		  try {
			  FileReader fr = new FileReader("src/fileHandling/new-file.txt");
			  while(fr.ready()) {
				  System.out.println(fr.read());
			  }
		  }catch(IOException e) {
			  System.out.println(e.getMessage());
		  }
		  
		  // create
		  try {
			 File fo = new File("random.txt");
			 fo.createNewFile();
			 fo.delete();
		  }catch(IOException e) {
			  System.out.println(e.getMessage());
		  }
		  
		  // delete
			
	}

}
