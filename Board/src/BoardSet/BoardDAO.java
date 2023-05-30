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
		
		ArrayList<Board> result = new ArrayList<>();
		
		Connection conn = conUt.getConnection();

		Properties p = new Properties();
	
		//boads 테이블에서 게시물 정보를 가져와서 출력하기
		 try (FileInputStream fis = new FileInputStream("C:/Users/금정산2_PC12/git/thirdJava/Board/resources/db")) {
	            p.load(fis);
	            
	            
				String sql = p.getProperty("listSQL");
				PreparedStatement pstmt = conn.prepareStatement(sql);
	            
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
	
	
	public void read(int bno) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		BoardService bs = new BoardService();
		Connection conn = conUt.getConnection();
		Scanner scanner = new Scanner(System.in);
		BoardDAO dao = new BoardDAO();

		Properties p = new Properties();

		 try (FileInputStream fis = new FileInputStream("C:/Users/금정산2_PC12/git/thirdJava/Board/resources/db")) {
	            p.load(fis);
	            
			String sql = p.getProperty("readSQL");
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql 준비시키고
			
			pstmt.setString(1, Integer.toString(bno));
			

			ResultSet rs = pstmt.executeQuery();
//			pstmt.executeUpdate();	

			if(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.println("#############");
				System.out.println("번호: " + board.getBno());
				System.out.println("제목: " + board.getBtitle());
				System.out.println("내용: " + board.getBcontent());
				System.out.println("쓴이: " + board.getBwriter());
				System.out.println("날짜: " + board.getBdate());
			
			System.out.println("-------------------------------------------------------------------");
			System.out.println("보조메뉴: 1.Update | 2.Delete ");
			System.out.print("메뉴선택: ");
			String menuNo = scanner.nextLine();
			System.out.println();
			
			if(menuNo.equals("1")) {
				
				
				bs.update(board.getBno());
				
			} else if(menuNo.equals("2")) {
				
				
				delete(board);
			}
			
			conUt.closeConnection(rs, pstmt, conn);
			}else {
				System.out.println("목록에 없습니다.");
			}
		 } catch (Exception e) {
		e.printStackTrace();
		bs.exit();
	}

				
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
