package Calender;

import java.util.Calendar;
import java.util.List;

public class MyCalendar {
	public void viewMonth(int year, int month) {
		System.out.println(year +"년" + month + "월");
		
		int months = month -1;
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month-1,1);
		//int strtDate = calendar.get(Calendar.DAY_OF_WEEK); // 시작 요일
		int weekDegree = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH); // 한달에 몇주차까지 있는지
		//int endDate = calendar.getActualMaximum(Calendar.DATE);				

		String value = "";
		List<String> days = List.of("일","월","화","수","목","금","토");
		
		for(String day: days) {
			value += day +"\t";
		}
		
			int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
			int ar[][] = new int[weekDegree][7];

			System.out.println(value);
			
			for(int j = 0 ; j < weekDegree; j++) {
			String nextStr = "";
			for(int m=1 ; m < 8; m++) {
				
				if(calendar.get(Calendar.DAY_OF_WEEK) != m) { //한 주 기준으로 그 주에 첫째 날짜를 요일 기준으로 정수 반환, 비교한다.ex) 일~토요일까지 1~7의 정수, 월요일이 1일이면 정수 2 반환
					nextStr += "\t";						// 만약 정수 순서에 따라서 반환되는 첫째 날짜의 요일이 m의 수와 다르다면 tap 띄워줌
				}else {
					nextStr += calendar.get(Calendar.DAY_OF_MONTH) + "\t"; //그 달의 날짜를 한 문자열에 tap 포함해서 한 행으로 받는다
					calendar.add(Calendar.DATE, 1);							// 포인트 된 날짜를 다음으로 넘겨줌
					if(calendar.get(Calendar.MONTH)!= months) break;		// 포인트 된 달이 넘어가면 break
				}

			}
			System.out.println(nextStr);
			
			}
						
		

	
		
	}

}
		
