package BoardSet;

import java.io.FileNotFoundException;
import java.io.IOException;
//import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	private Scanner scanner = new Scanner(System.in);
//	private Connection conn;
	public static ConnUtil cu = new ConnUtil();
	public BoardService bs = new BoardService();

	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Main m = new Main();
		
		while(true) {
		m.mainMenu();					// 메인메뉴 출력 1: create 2:read 3:clear 4:exit
		}
	}
	
	public void mainMenu() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("메인메뉴: 1.Create | 2.Read | 3.Clear | 4.list | 5.Exit");
		System.out.print("메뉴선택: ");
		String menuNo = scanner.nextLine();
		System.out.println();
		

		switch(menuNo) {
			case "1" : bs.create();	break;
			case "2" : bs.read();	break;
			case "3" : bs.clear();	break;
			case "4" : bs.list();   break;
			case "5" : bs.exit();	break;
		}
		
		
		
	}	

}
