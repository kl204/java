package ScoreService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;


public class Main {
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.readyData();
		main.Start();
		
	}
	
	public void Start() throws Exception {
		System.out.println("시험지를 배부합니다.");
		
		ArrayList<Student> data = null;
		data = this.readyData();
		
		DataService quiz = new DataService(data);
		
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
	
	private ArrayList<Student> readyData() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("resource/Abc1115.txt"));
		ArrayList<Student> dataList = new ArrayList<Student>(); // 파싱해서 보내져아할 리스트
		int rows;
		
			
		while(true) {
			Student setStudent = new Student();
			String str = br.readLine();
			int changeNum;
			String course;
			int[] courseArr = new int[6];
			String getChar;
			int j = 0; // 과목 배열 수
//			int cnt = 3;
			
			if(str==null) break;			
		
			changeNum = Integer.parseInt(str.substring(0, 6));
			setStudent.setStdNum(changeNum); 					//stdNo
			

			
			setStudent.setEmail(str.substring(6, 10));			//email

			
			for(int i = 10 ; i < 26; i+=3) {
				
				course = str.substring(i,i+3).trim();
				
				courseArr[j] = Integer.parseInt(course);
			
				j++;
//				cnt++;
			}
			setStudent.setCourseScore(courseArr);				// kor, eng, math, sci, hist
			
			


			
			changeNum = Integer.parseInt(str.substring(25, 28).replaceAll("\\s", "0"));
			setStudent.setTotalScore(changeNum);				// totalScore

		
			getChar = str.substring(28, 29);
			setStudent.setProfCode(getChar);					//mngCode
			
			getChar = str.substring(29, 30);
			setStudent.setAchv(getChar);						//accCode
			
			
			getChar = str.substring(30, 31);
			setStudent.setLocalCode(getChar);					//locCode
			
			
			dataList.add(setStudent); // 한명의 학생 행 추가
			
			
						
		}
		
		
		
		
		
//		rows = pstmt.executeUpdate();
//		System.out.println("저장된 행 수 : "+ rows);
		// sql 쿼리 조회에 대한 결과 값 받는 클래스 : Resultset resultSet = pstmt.executeQuery("sql 질의 쿼리문");
		
		
		return dataList;
	}

	private void submitAnswer(int num, String ansewer) {
		
		System.out.println("답 :" +ansewer);
		
	}

}
