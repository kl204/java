package BoardSet;

import java.io.FileNotFoundException;
import java.io.IOException;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardService {
	private Scanner scanner = new Scanner(System.in);

	
	public void create() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		//입력 받기
		BoardDAO dao = new BoardDAO();
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목: "); 
		board.setBtitle(scanner.nextLine());
		System.out.print("내용: "); 	
		board.setBcontent(scanner.nextLine());
		System.out.print("글쓴이: "); 	
		board.setBwriter(scanner.nextLine());
		
		//보조메뉴 출력
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("보조메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴선택: ");
		String menuNo = scanner.nextLine();
		if(menuNo.equals("1")) {
			//boards 테이블에 게시물 정보 저장
			
			dao.create(board.getBtitle(), board.getBcontent(), board.getBwriter());
		
		}
		
		//게시물 목록 출력
		this.list();
	}
	
	//Method	
	public void list() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		BoardDAO dao = new BoardDAO();

		
		//타이틀 및 컬럼명 출력
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-----------------------------------------------------------------------");
		
		//boads 테이블에서 게시물 정보를 가져와서 출력하기
	
			ArrayList<Board> rs = new ArrayList<>();
			
			rs = dao.list();

			for(Board br : rs) {
				
 
				System.out.printf("%-6s%-12s%-16s%-40s \n", 
						br.getBno(), 
						br.getBwriter(),
						br.getBdate(),
						br.getBtitle());
			}

		
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
//			exit();
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
//				exit();
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
//			exit();
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
//				exit();
//			}
//		}
//			
//		//게시물 목록 출력
//		list();
//	}
	
	public void exit() {

		System.out.println("** 게시판 종료 **");
		System.exit(0);
	}
	
	
	
	

}
