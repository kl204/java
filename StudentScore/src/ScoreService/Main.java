package ScoreService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.readyData();
		
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
		
		Connection conn  = null; 
	
		try {
			//jdbc Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//연결하기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/students",
					"root",
					"0000");
			
		String sql = "INSERT INTO student(stdNo, email, kor, eng, math, sci, hist, totalScore"
				+ "mngCode, accCode, locCode)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// sql에 컬럼이 없어서 생성을 해야된다는 오류가 있는 것 같음, 실행해보고 해결
				
		while(true) {
			Student setStudent = new Student();
			String str = br.readLine();
			int changeNum;
			String course;
			int[] courseArr = new int[5];
			String getChar;
			int j = 0; // 과목 배열 수
			int cnt = 3;
			
			if(str==null) break;
			
			changeNum = Integer.parseInt(str.substring(0, 6));
			setStudent.setStdNum(changeNum); 					//stdNo
			
			pstmt.setString(1, str.substring(0, 6));
			
			setStudent.setEmail(str.substring(6, 11));			//email
			pstmt.setString(2, str.substring(6, 11));

			
			for(int i = 11 ; i < 26; i+=3) {
				
				course = str.substring(i,i+2).trim();

				pstmt.setString(cnt, course);
				
				courseArr[j] = Integer.parseInt(course);
			
				j++;
				cnt++;
			}
			setStudent.setCourseScore(courseArr);				// kor, eng, math, sci, hist

			
			changeNum = Integer.parseInt(str.substring(25, 28).replaceAll("\\s", "0"));
			setStudent.setTotalScore(changeNum);				// totalScore
			pstmt.setString(8, str.substring(25, 28).replaceAll("\\s", "0"));

		
			getChar = str.substring(28, 29);
			setStudent.setProfCode(getChar);					//mngCode
			pstmt.setString(9, getChar);
			
			getChar = str.substring(29, 30);
			setStudent.setAchv(getChar);						//accCode
			pstmt.setString(10, getChar);
			
			
			getChar = str.substring(30, 31);
			setStudent.setLocalCode(getChar);					//locCode
			pstmt.setString(11, getChar);
			
			
			dataList.add(setStudent); // 한명의 학생 행 추가
			
		}
		
		int rows = pstmt.executeUpdate();
		
		System.out.println("저장된 행 수 : "+ rows);
		
		pstmt.close();
		br.close(); // BufferedReader와 연결된 FileReader도 닫음
		
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			finally {
		
			if(conn != null) {
				try {
					//연결 끊기
					conn.close();
					
					System.out.println("연결 끊기");
				} catch (SQLException e2) {
					// TODO: handle exception
				}
			}
		}
		
		return dataList;
	}

	private void submitAnswer(int num, String ansewer) {
		
		System.out.println("답 :" +ansewer);
		
	}

}
