package BoardSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class BoardDAO {
	public ConnUtil conUt = new ConnUtil(); 
	
	
//	ResultSet rs = pstmt.executeQuery();	--> select와 같이 리턴될 데이터가 있을 때 사용한다		
//	pstmt.executeUpdate();					--> insert update delete와 같이 리턴 될 값이 없을때 사용한다.

	
	
	public void create(String btitle, String bcontent, String bwriter) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		BoardService bs = new BoardService();
		Connection conn = conUt.getConnection();

		Properties p = new Properties();

		 try (FileInputStream fis = new FileInputStream("C:/Users/금정산2_PC12/git/thirdJava/Board/resources/db")) {
	            p.load(fis);
	            
			String sql = p.getProperty("insertSQL");
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql 준비시키고
			
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);			// 준비 시킨 sql에 ? 순서대로 넣고
			pstmt.setString(3, bwriter);
			
			pstmt.executeUpdate();
			
			conUt.closeConnection(null, pstmt, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
			bs.exit();
		}
	
	
	//게시물 목록 출력
	bs.list();
	}
	
	
	//Method	
	public ArrayList<Board> list() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		BoardService bs = new BoardService();
		
		ArrayList<Board> result = new ArrayList<>(); // 가져온 Board 타입 데이터 행(튜플)들을 받기 위한 ArrayList
		
		Connection conn = conUt.getConnection(); // PreparedStatement 사용하여 sql 쓰기 위해서 connection 함

		Properties p = new Properties();
	
		//boads 테이블에서 게시물 정보를 가져와서 출력하기
		 try (FileInputStream fis = new FileInputStream("C:/Users/금정산2_PC12/git/thirdJava/Board/resources/db")) {
	            p.load(fis);
	            
	            
				String sql = p.getProperty("listSQL");
				PreparedStatement pstmt = conn.prepareStatement(sql); // sql 쓰기 위해서 준비
	            
				
				ResultSet rs = pstmt.executeQuery();
				
				
			while(rs.next()) {		
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				
				result.add(board);
						
			}
			
			conUt.closeConnection(rs, pstmt, conn);
			
		} catch(SQLException e) {
			e.printStackTrace();
			bs.exit();
		}
		
		return result;
		
	}
	
	
	public Board read(int bno) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		BoardService bs = new BoardService();
		Connection conn = conUt.getConnection();
//		Scanner scanner = new Scanner(System.in);
//		BoardDAO dao = new BoardDAO();
		Board board = new Board();	

		Properties p = new Properties();

		 try (FileInputStream fis = new FileInputStream("C:/Users/금정산2_PC12/git/thirdJava/Board/resources/db")) {
	            p.load(fis);
	            
			String sql = p.getProperty("readSQL");
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql 준비시키고
			
			pstmt.setString(1, Integer.toString(bno));
			

			ResultSet rs = pstmt.executeQuery();			
//			pstmt.executeUpdate();	

			
			
			//--> if(rs.next()) 같은 경우 쿼리가 한번밖에 안날라온다. while을 써야 계속 받을 수 있음. 시험
			
			if(rs.next()) { // ResultSet 클래스인 next()는 Select 결과의 존재여부 확인, ResultSet은 select 쿼리 결과를 행으로 저장하며
							//커서를 통해서 각 행의 데이터에 접근, 최초의 커서는 1행 이전에 존재하기 때문에 넘겨줘야 읽을 수 있다.
							// next()의 return은 존재할 시 true로 반환 된다. 마지막행에 커서 도달시 false 반환
//				Board board = new Board();							//Board DTO의 객체를 생성해서 출력을 위하여 받아주게 된다.
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				

			
			conUt.closeConnection(rs, pstmt, conn);
			}else {
				System.out.println("목록에 없습니다.");
			}
		 } catch (Exception e) {
		e.printStackTrace();
		bs.exit();
	}
		 
		 return board;

				
	}
	
	public void update(Board board) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		BoardService bs = new BoardService();
		Connection conn = conUt.getConnection();

		Properties p = new Properties();
		
		 try (FileInputStream fis = new FileInputStream("C:/Users/금정산2_PC12/git/thirdJava/Board/resources/db")) {
	            p.load(fis);
	            
			String sql = p.getProperty("updateSQL");
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql 준비시키고
			
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());			// 준비 시킨 sql에 ? 순서대로 넣고
			pstmt.setString(3, board.getBwriter());
			pstmt.setString(4, Integer.toString(board.getBno()));		
			
			pstmt.executeUpdate();
			
			conUt.closeConnection(null, pstmt, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
			bs.exit();
		}
	
	
	//게시물 목록 출력
	bs.list();	

	}
	
	public void delete(Board board) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		//boards 테이블에 게시물 정보 삭제
		
		BoardService bs = new BoardService();
		Connection conn = conUt.getConnection();

		Properties p = new Properties();
		
		 try (FileInputStream fis = new FileInputStream("C:/Users/금정산2_PC12/git/thirdJava/Board/resources/db")) {
	            p.load(fis);
	            
			String sql = p.getProperty("deleteSQL");
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql 준비시키고
			
			
			pstmt.setInt(1, board.getBno());
			
			pstmt.executeUpdate();
			
			conUt.closeConnection(null, pstmt, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
			bs.exit();
		}
	
	
	//게시물 목록 출력
	bs.list();

	}
	
	public void clear() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		BoardService bs = new BoardService();
		Connection conn = conUt.getConnection();

		Properties p = new Properties();

		 try (FileInputStream fis = new FileInputStream("C:/Users/금정산2_PC12/git/thirdJava/Board/resources/db")) {
	            p.load(fis);
	            
			String sql = p.getProperty("clearSQL");
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql 준비시키고

			pstmt.executeUpdate();
			
			conUt.closeConnection(null, pstmt, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
			bs.exit();
		}
	
	
	//게시물 목록 출력
	bs.list();
		

}
	
}
