package BoardSet;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnUtil {
	
	public void closeConnection(ResultSet rs, Statement stmt, Connection con) {
		
		if(rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
					
			rs = null;
		}
		
		if(stmt!=null) {
			
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

			stmt = null;
		}
		
		if(con!=null) {
			
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

			stmt = null;
		}
		
		
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		//환경정보는 값이 바뀌기 때문에 밖에서 결정되어야 한다.
		//Properties class 이용하여 값 설정
		//Stream 이용하여 값 설정
				
		Properties p = new Properties();
		

        try(FileInputStream input = new FileInputStream("C:/Users/금정산2_PC12/git/thirdJava/Board/resources/db"))  {
            p.load(input);
            
            Class.forName(p.getProperty("driver"));
            
            con = DriverManager.getConnection(p.getProperty("jdbcURL"), p.getProperty("id"), p.getProperty("password"));
                       
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		return con;
	}
	

	
	

}