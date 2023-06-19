package BoardSet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public void read() {
		BoardDAO dao = new BoardDAO();
		Board board = new Board();
		//입력 받기
		System.out.println("[게시물 읽기]");
		System.out.print("bno: "); 	
		int bno = Integer.parseInt(scanner.nextLine());
		
		//boards 테이블에서 해당 게시물을 가져와 출력
		try {

			board = dao.read(bno);			
						
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
			
			
			update(bno);				// 해당 행의 데이터 업데이트를 위해서 가져온 Bno를 넘겨준다.
			
		} else if(menuNo.equals("2")) {
			
			
			dao.delete(board);
		}

		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}

	}	
	
	
	public void update(int bno) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		BoardDAO dao = new BoardDAO();
		Board board = new Board();
		
		//수정 내용 입력 받기
		System.out.println("[수정 내용 입력]");
		System.out.print("제목: "); 	
		board.setBtitle(scanner.nextLine());
		System.out.print("내용: "); 	
		board.setBcontent(scanner.nextLine());
		System.out.print("글쓴이: "); 	
		board.setBwriter(scanner.nextLine());
		board.setBno(bno);
		
		//보조메뉴 출력
		System.out.println("-------------------------------------------------------------------");
		System.out.println("보조메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴선택: ");
		String menuNo = scanner.nextLine();
		if(menuNo.equals("1")) {
			//boards 테이블에서 게시물 정보 수정
			try {
				
				
				dao.update(board);

			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		
		//게시물 목록 출력
		list();
	}

	
	public void clear() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		BoardDAO dao = new BoardDAO();
		
		System.out.println("[게시물 전체 삭제]");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("보조메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴선택: ");
		String menuNo = scanner.nextLine();
		if(menuNo.equals("1")) {
			//boards 테이블에 게시물 정보 전체 삭제
			try {
				dao.clear();

			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
			
		//게시물 목록 출력
		this.list();
	}
	
	public void exit() {

		System.out.println("** 게시판 종료 **");
		System.exit(0);
	}
	
	
	
	

}
