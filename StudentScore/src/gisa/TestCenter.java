package gisa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class TestCenter {
	
	public static void main(String[] args) throws Exception {
		//String path = "/resource/Abc1115.txt";
		TestCenter tc = new TestCenter();
		tc.startTest();
	}
	
	public void startTest() throws Exception {
		System.out.println("시험지를 배부합니다.");
		
		ArrayList<StudentDTO> data = null;
		data = this.readyData();
		
		GisaQuiz quiz = new GisaQuiz(data);
		String answer = null;
		answer = quiz.solveQuiz1();
		this.submitAnswer(1, answer);
		answer = quiz.solveQuiz2();
		this.submitAnswer(2, answer);
		answer = quiz.solveQuiz3();
		this.submitAnswer(3, answer);
		answer = quiz.solveQuiz4();
		this.submitAnswer(4, answer);
		
		System.out.println("답안지를 모두 제출합니다.");
		System.out.println("시험을 종료합니다.");
	}
	
	private ArrayList<StudentDTO> readyData() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<StudentDTO> data = null;
		//파일 접속
		File file = new File("./resource/Abc1115.txt");
		if(file.exists()) {
			System.out.println(file.length());
		}else {
			System.out.println("fails");
		}
		
		//파일 한 라인 읽기
		FileReader fr = new FileReader(file); 
		
		//라인 분리하기
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		data = new ArrayList<StudentDTO>();
		
		while((line = br.readLine())!=null) {
			System.out.println(line);
			//하나의 라인에서 11개의 데이터 분리
			
			//DTO객체 만들기
			
			//리스트에 저장하기

		}
		
		
		

		
		//위의 작업 1000번 반복
		
		br.close();
		fr.close();
		return null;
	}

	private void submitAnswer(int num, String ansewer) {
		
	}

}
