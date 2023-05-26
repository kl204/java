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

public class BoardDAO {
	public ConnUtil conUt = new ConnUtil(); 

	
	
	public void create(String btitle, String bcontent, String bwriter) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		BoardService bs = new BoardService();
		Connection conn = conUt.getConnection();

		Properties p = new Properties();

		 try (FileInputStream fis = new FileInputStream("lib/db.properties")) {
	            p.load(fis);
	            
			String sql = p.getProperty("insertSQL");
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql 준비시키고
			
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);			// 준비 시킨 sql에 ? 순서대로 넣고
			pstmt.setString(3, bwriter);

			ResultSet rs = pstmt.executeQuery();
			pstmt.executeUpdate();
			
			conUt.closeConnection(rs, pstmt, conn);
			
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
		 try (FileInputStream fis = new FileInputStream("lib/db.properties")) {
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
	
//	
//	public void read() {
//		//입력 받기
//		System.out.println("[게시물 읽기]");
//		System.out.print("bno: "); 	
//		int bno = Integer.parseInt(scanner.nextLine());
//		
//		//boards 테이블에서 해당 게시물을 가져와 출력
//		try {
//			String sql = "" +
//				"SELECT bno, btitle, bcontent, bwriter, bdate " +
//				"FROM boards " +
//				"WHERE bno=?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bno);
//			ResultSet rs = pstmt.executeQuery();
//			if(rs.next()) {
//				Board board = new Board();
//				board.setBno(rs.getInt("bno"));
//				board.setBtitle(rs.getString("btitle"));
//				board.setBcontent(rs.getString("bcontent"));
//				board.setBwriter(rs.getString("bwriter"));
//				board.setBdate(rs.getDate("bdate"));
//				System.out.println("#############");
//				System.out.println("번호: " + board.getBno());
//				System.out.println("제목: " + board.getBtitle());
//				System.out.println("내용: " + board.getBcontent());
//				System.out.println("쓴이: " + board.getBwriter());
//				System.out.println("날짜: " + board.getBdate());
//				//보조메뉴 출력
//				System.out.println("-------------------------------------------------------------------");
//				System.out.println("보조메뉴: 1.Update | 2.Delete | 3.List");
//				System.out.print("메뉴선택: ");
//				String menuNo = scanner.nextLine();
//				System.out.println();
//				
//				if(menuNo.equals("1")) {
//					update(board);
//				} else if(menuNo.equals("2")) {
//					delete(board);
//				}
//			}
//			rs.close();
//			pstmt.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			bs.exit();
//		}
//		
//		//게시물 목록 출력
//		list();
//	}
//	
//	public void update(Board board) {
//		//수정 내용 입력 받기
//		System.out.println("[수정 내용 입력]");
//		System.out.print("제목: "); 	
//		board.setBtitle(scanner.nextLine());
//		System.out.print("내용: "); 	
//		board.setBcontent(scanner.nextLine());
//		System.out.print("글쓴이: "); 	
//		board.setBwriter(scanner.nextLine());
//		
//		//보조메뉴 출력
//		System.out.println("-------------------------------------------------------------------");
//		System.out.println("보조메뉴: 1.Ok | 2.Cancel");
//		System.out.print("메뉴선택: ");
//		String menuNo = scanner.nextLine();
//		if(menuNo.equals("1")) {
//			//boards 테이블에서 게시물 정보 수정
//			try {
//				String sql = "" +
//					"UPDATE boards SET btitle=?, bcontent=?, bwriter=? " +
//					"WHERE bno=?";
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, board.getBtitle());
//				pstmt.setString(2, board.getBcontent());
//				pstmt.setString(3, board.getBwriter());
//				pstmt.setInt(4, board.getBno());
//				pstmt.executeUpdate();
//				pstmt.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//				bs.exit();
//			}
//		}
//		
//		//게시물 목록 출력
//		list();
//	}
//	
//	public void delete(Board board) {
//		//boards 테이블에 게시물 정보 삭제
//		try {
//			String sql = "DELETE FROM boards WHERE bno=?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, board.getBno());
//			pstmt.executeUpdate();
//			pstmt.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			bs.exit();
//		}
//		
//		//게시물 목록 출력		
//		list();
//	}
//	
//	public void clear() {
//		System.out.println("[게시물 전체 삭제]");
//		System.out.println("-------------------------------------------------------------------");
//		System.out.println("보조메뉴: 1.Ok | 2.Cancel");
//		System.out.print("메뉴선택: ");
//		String menuNo = scanner.nextLine();
//		if(menuNo.equals("1")) {
//			//boards 테이블에 게시물 정보 전체 삭제
//			try {
//				String sql = "TRUNCATE TABLE boards";
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.executeUpdate();
//				pstmt.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//				bs.exit();
//			}
//		}
//			
//		//게시물 목록 출력
//		list();
//	}



}
