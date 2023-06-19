package sec.calendar.prj;

import java.util.Calendar;
import java.util.List;

public class MyCalendar {
	public void viewMonth(int year, int month) {
		System.out.println(year +"년" + month + "월");
		
		int months = month -1;
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month-1,1);
		int i = calendar.get(Calendar.DAY_OF_WEEK); // 시작 요일
		int i1 = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH); // 
		int endDate = calendar.getActualMaximum(Calendar.DATE);
		
		int arr[][] = new int[i1][7];
		
		int cnt = 0;
		String value = "";
		List<String> days = List.of("일","월","화","수","목","금","토");
		
		for(String day: days) {
			value += day +"\t";
		}
		
			int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
			int ar[][] = new int[i1][7];

			System.out.println(value);
			
			for(int j = 0 ; j < i1; j++) {
			String nextStr = "";
			for(int m=0 ; m < 7; m++) {
				if(calendar.get(Calendar.DAY_OF_WEEK) != m+1) {
					nextStr += "\t";
				}else {
					nextStr += calendar.get(Calendar.DAY_OF_MONTH) + "\t";
					calendar.add(Calendar.DATE, 1);
					if(calendar.get(Calendar.MONTH)!= months) break;
				}

			}
			System.out.println(nextStr);
			
			}
						
		

	
		
	}

}
		
