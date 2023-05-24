package ScoreService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		Connection conn = new Connection();
		
		conn.Connection();
		
//		Main main = new Main();
//		main.Start();
		
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
				
		while(true) {
			Student setStudent = new Student();
			String str = br.readLine();
			int changeNum;
			String course;
			int[] courseArr = new int[5];
			String getChar;
			int j = 0; // 과목 배열 수
			
			if(str==null) break;
			
			changeNum = Integer.parseInt(str.substring(0, 6));
			setStudent.setStdNum(changeNum); 
			
			setStudent.setEmail(str.substring(6, 11));
			

			
			for(int i = 11 ; i < 26; i+=3) {

				course = str.substring(i,i+2).trim();

				courseArr[j] = Integer.parseInt(course);
			
				j++;
			}
			setStudent.setCourseScore(courseArr);
			
			changeNum = Integer.parseInt(str.substring(25, 28).replaceAll("\\s", "0"));
			setStudent.setTotalScore(changeNum);
			
		
			getChar = str.substring(28, 29);
			setStudent.setProfCode(getChar);
			
			getChar = str.substring(29, 30);
			setStudent.setAchv(getChar);
			
			getChar = str.substring(30, 31);
			setStudent.setLocalCode(getChar);
			
			dataList.add(setStudent); // 한명의 학생 행 추가
			
			
			

		}
		
		//br.close(); // BufferedReader와 연결된 FileReader도 닫음
		
		return dataList;
	}

	private void submitAnswer(int num, String ansewer) {
		
		System.out.println("답 :" +ansewer);
		
	}

}
