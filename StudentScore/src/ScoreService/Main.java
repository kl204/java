package ScoreService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("resource/Abc1115.txt"));
		
		int lineNo = 1;
		while(true) {
			String str = br.readLine();
			if(str==null) break;
			System.out.println(lineNo + "\t" +str);
			lineNo++;
		}
		
	
		
		Main main = new Main();
		main.Start();
		
		br.close(); // BufferedReader와 연결된 FileReader도 닫음
	}
	
	public void Start() {
		
	}

}
