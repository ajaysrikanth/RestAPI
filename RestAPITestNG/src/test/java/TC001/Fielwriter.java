package TC001;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fielwriter {
	
	String line = null;

	public void writer() throws IOException {
		FileWriter fw = new FileWriter("./ex.txt");

		BufferedWriter bw = new BufferedWriter(fw);

		bw.append("Hi file writer \n");
		bw.append("this is liene 2");

		bw.close();
	}
	
	public void reader( ) throws IOException {
		
		FileReader fr = new FileReader("./ex.txt");
		
		BufferedReader br = new BufferedReader(fr);
		
		while((line=br.readLine())!=null) {
			System.out.println(line);
		}
		br.close();
	}
	public static void main(String[] args) throws IOException {

		Fielwriter fwr = new Fielwriter();
		fwr.writer();
		fwr.reader(); 
		
		

	}

}
