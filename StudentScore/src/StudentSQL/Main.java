package StudentSQL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.mysql.cj.protocol.Resultset;


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
				
		DataSeriveQuary quiz = new DataSeriveQuary();
		
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
																// 전송할 쿼리 문자열 준비
			
		StringBuffer bf = new StringBuffer("INSERT INTO student(stdNo, email, kor, eng, math, sci, hist, totalScore, mngCode, accCode, locCode)");		//StringBuffer 사용하는 것으로 수정
		bf.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			
		String sql = bf.toString();
			
		//String sql = "INSERT INTO student(stdNo, email, kor, eng, math, sci, hist, totalScore, mngCode, accCode, locCode)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
																// 쿼리 보낼 PreparedStatement 준비
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet resultSet = pstmt.executeQuery("select * from student where stdNo=990001");		// ResultSet(java.sql.ResultSet)은 executeQuery(String sql)을 통해 쿼리 실행, 결과값 저장 클래스, getInt(index) 와 같이 불러올수 있다		

		resultSet.next(); // 질의문 전송 하고 result 커서를 다음으로 넘겨주어야 한다.
		
		if(resultSet.getInt(1)!=990001) {// 데이터의 첫번째 학번이 들어가 있다면 전체 데이터가 존재하는 것으로 인지하여 break;
		
			
		while(true) {
			Student setStudent = new Student();
			String str = br.readLine();							// resource/Abc1115.txt 의 텍스트를 한줄씩 불러옴
			String course;										// 과목 점수 문자열
			int[] courseArr = new int[6];						// 과목들의 점수를 저장하는 int형 배열
			String getChar;										// A, B, C 와 같이 단일 문자 temp 변수
			int j = 0; 											// 과목 배열 수

			
			if(str==null) break;			
					
			pstmt.setString(1, str.substring(0, 6));			//stdNo
						
			pstmt.setString(2, str.substring(6, 10));			//email
		
			for(int i = 10 ; i < 26; i+=3) {								
				course = str.substring(i,i+3).trim();							
				courseArr[j] = Integer.parseInt(course);			
				j++;
			}
						
			for(int i = 0; i < 5; i++) {
				pstmt.setString(i+3, Integer.toString(setStudent.getCourseScore(i))); // kor, eng, math, sci, hist	

				}
					
				pstmt.setString(8, str.substring(25, 28).replaceAll("\\s", "0"));		// totalScore

		
				getChar = str.substring(28, 29);					
				pstmt.setString(9, getChar);											//mngCode
			
				getChar = str.substring(29, 30);						
				pstmt.setString(10, getChar);											//accCode
			
			
				getChar = str.substring(30, 31);				
				pstmt.setString(11, getChar);											//locCode
						
				dataList.add(setStudent); // 한명의 학생 행 추가
						
				pstmt.executeUpdate();
						
			}
		
		}
		
		pstmt.close();	//PreparedStatement 닫기
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
					
					//System.out.println("연결 끊기");
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
