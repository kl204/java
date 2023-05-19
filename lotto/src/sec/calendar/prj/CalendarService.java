package sec.calendar.prj;

import java.util.Scanner;

public class CalendarService {
	public static void main(String[] args) {
		CalendarService cs = new CalendarService();
		cs.startService();
	}
	
	public void startService() {
		//달력을 만들어내는 객체를 이용하여 서비스하는 내용
		//원하는 만큼 달력을 만들어 낼 수 있다.
		//원하는 달, 또는 원하는 년도의 모든 월을 볼 수 있다.
		Scanner input = new Scanner(System.in); 
		MyCalendar mycal = new MyCalendar();
		System.out.println("서비스를 시작합니다.");
		
		boolean flag = false;
		while(!flag) {
			//년도를 입력받고
			System.out.println("년도를 입력하세요 >>>");
			String temp = input.nextLine();
			int year = Integer.parseInt(temp);
			//월을 입력받고(월 전체인지, 1개월인지 확인)
			System.out.println("월을 입력하세요[해당년도의 월 전체출력:13입력] >>>");
			temp = input.nextLine();
			int month = Integer.parseInt(temp);
			//객체에게 요청
			if(month==13) {
				for(int i= 0;i <12;i++) {
					mycal.viewMonth(year, i+1);
				}
				}else {
					mycal.viewMonth(year, month);
				}
		
			
			//mycal.viewMonth(year, month);
			//계속서비스 이용할지 물어보고 
			System.out.println("계속 이용하시겠습니까?[예:yes,아니오:no] >>>");
			String cmd = input.nextLine(); // 한줄의 문자열을 읽어옴
			if(cmd.equals("no")) {
				System.out.println("이용해주셔서 감사합니다.");
				flag = true;				//break; 

			}
		}

		input.close();

	}
	
}
