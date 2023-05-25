package StudentSQL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class DataSeriveQuary {
	java.sql.Connection conn  = null;

	public String solveQuiz1() {
		String answer = null; // 답 제출 문자열
		
try {
	
	//jdbc Driver 등록
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//연결하기
	conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/students",
			"root",
			"0000");
	
	
	String sql = "select stdNo from student where locCode = 'B' order by kor+eng desc, stdNo asc limit 4,1";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);

	ResultSet resultSet = pstmt.executeQuery();		
	
	resultSet.next();
	
	answer = Integer.toString(resultSet.getInt(1));
	
	pstmt.close();

	
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
			
		} catch (SQLException e2) {
			// TODO: handle exception
		}
	}
}

		return answer;
	}
	
	public String solveQuiz2() {
		String answer = null; // 답 제출 문자열
		
		try {
			
			//jdbc Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//연결하기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/students",
					"root",
					"0000");
			
			
			String sql = "select distinct(max(kor+eng)) as maxSore from student where locCode = 'B'";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();		
			
			resultSet.next();
		
			answer = Integer.toString(resultSet.getInt(1));
			
			pstmt.close();

			
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
					
				} catch (SQLException e2) {
					// TODO: handle exception
				}
			}
		}


		return answer;
	}

	public String solveQuiz3() {
		String answer = null; // 답 제출 문자열
		
		try {
			
			//jdbc Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//연결하기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/students",
					"root",
					"0000");
			
			
			String sql = "select case when accCode= 'A' then 5 when accCode= 'B' then  totalScore + 15 when accCode= 'C' then  20 end as SumP from student where eng + math >=120";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();		
			
			resultSet.next();
		
			answer = Integer.toString(resultSet.getInt(1));
			
			pstmt.close();

			
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
					
				} catch (SQLException e2) {
					// TODO: handle exception
				}
			}
		}



		return answer;
	}

	public String solveQuiz4() {
		String answer = null; // 답 제출 문자열
		
		
		try {
			
			//jdbc Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//연결하기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/students",
					"root",
					"0000");
			
			
			String sql = "select count(case when locCode= 'A' then kor + 5 when locCode= 'B' then kor + 10 end) as cnt from student where accCode = 'A' or accCode = 'B'";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();		
			
			resultSet.next();
		
			answer = Integer.toString(resultSet.getInt(1));
			
			pstmt.close();

			
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
					
				} catch (SQLException e2) {
					// TODO: handle exception
				}
			}
		}

		return answer;
	}


}



