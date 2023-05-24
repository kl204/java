package ScoreService;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	
	public void Connection() {
		java.sql.Connection conn  = null;
		
		try {
			//jdbc Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//연결하기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/students",
					"root",
					"0000");
			
			//매개변수화된 SQL문 작성
			
			//PreparedStatement 얻기 및 값 지정
			
			//SQL 문 실행
			
			//PreparedStatement 닫기
			
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
	}

	
	

}
