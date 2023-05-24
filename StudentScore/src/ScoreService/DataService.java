package ScoreService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class DataService {
	private ArrayList<Student> dataList;						// 파싱된 데이터리스트
	
	public DataService(ArrayList<Student> dataList) {
		this.dataList = dataList; //인자가 있는 생성자가 있을 때에는 인자가 없는 디폴트 생성자를 만들수가 없기 때문에 생성자에 매개변수를 주고
									// 생성자를 만들어 버리면 데이터를 써야만 하는 클래스에 대해서 데이터가 없는 상태에서 클래스를 생성하는
									// 상황을 방지해줄 수 있다.
	}
	

	public String solveQuiz1() {
		
		String answer = null; // 답 제출 문자열
		
		ArrayList<Student> dSortt = new ArrayList<>();	// 지역코드 B인 데이터 리스트
		String chkcode =null;	// equals로 지역코드 B인지 확인하기 위한 문자열

//		int chkk = 0;			//dSortt 데이터 리스트의 인덱스를 카운트해주는 정수
		
		for(Student std : dataList) {	
			
			chkcode = std.getLocalCode();	// dataList에 있는 지역 코드를 담는다
			
			if(chkcode.equals("B")) { // 지역 코드가 B인 자료에 대하여
				
				dSortt.add(std);			// 지역코드가 B인 객체를 dataList에서 가져와서 담는다
//				dSortt.get(chkk).setCourseScore(std.getCourseScore());
//				dSortt.get(chkk).setStdNum(std.getStdNum());
				

//				System.out.println(dSortt.get(chkk).getStdNum());				
//				System.out.println(dSortt.get(chkk).getCourseScore(0)+dSortt.get(chkk).getCourseScore(1));
				
			}
		}
		
		Collections.sort(dSortt, Collections.reverseOrder()); // 내림차순 정렬

				
//		System.out.println(dSortt.size());
//		for(Student dtl : dSortt) {
//			
//			System.out.println(dtl.getStdNum());
//			System.out.println(dtl.getCourseScore(0) + dtl.getCourseScore(1));
//			
//		}
				
		for(int i = 0; i < dSortt.size();i++) { // 국어 + 영어 점수를 비교해주기 위한 for문
			
			int preNum = dSortt.get(i).getCourseScore(0) + dSortt.get(i).getCourseScore(1);
			for(int j = 0; j < dSortt.size();j++) {
				if(i!=j) {
					int curNum = dSortt.get(j).getCourseScore(0) + dSortt.get(j).getCourseScore(1);
					if(preNum == curNum) { // 국어 + 영어의 점수가 같을 때
//						System.out.println(preNum + " = " + curNum);
						if(dSortt.get(i).getStdNum() < dSortt.get(j).getStdNum()) { //오름차순 스왑
							
		// 궁금한점 : i 가 앞이고 j 가 뒤인데 위 if 문에 따르면 내림 차순이 되어야 하는데 왜 오름차순이 되는건지..					
							
							System.out.println(dSortt.get(i).getStdNum() +" > " + dSortt.get(j).getStdNum());

							Collections.swap(dSortt, i, j); // 오름차순, 점수가 같은 객체 중 앞의 객체의 학번이 뒤의 객체 학번보다 높으면 교체
							
							System.out.println(dSortt.get(i).getStdNum() +" > " + dSortt.get(j).getStdNum());
							System.out.println("---------------------------------------");
						}
					}
				}
			}
		}
		
		for(Student dtl : dSortt) {
		
		System.out.println("--------------------------------------");
		System.out.println(dtl.getStdNum());
		System.out.println(dtl.getCourseScore(0)+dtl.getCourseScore(1));

			
		}
		

		int chk = 0;
		
		for(Student dl : dSortt) { // 4번째 자리 학번 출력
			chk++;
			if(chk == 3) {
				answer = Integer.toString(dl.getStdNum());
				
				break;
			}
		}
		
		
		return answer;
	}
	
	public String solveQuiz2() {
		String answer = null; // 답 제출 문자열
		
		ArrayList<Student> dSortt = new ArrayList<>();	// 지역코드 B인 데이터 리스트
		String chkcode =null;	// equals로 지역코드 B인지 확인하기 위한 문자열
		
		for(Student std : dataList) {	
			
			chkcode = std.getLocalCode();	// dataList에 있는 지역 코드를 담는다
			
			if(chkcode.equals("B")) { // 지역 코드가 B인 자료에 대하여
				
				dSortt.add(std);			// 지역코드가 B인 객체를 dataList에서 가져와서 담는다

//				System.out.println(dSortt.get(chkk).getStdNum());				
//				System.out.println(dSortt.get(chkk).getCourseScore(0)+dSortt.get(chkk).getCourseScore(1));
				
			}
		}
		
			
		Collections.sort(dSortt, Collections.reverseOrder()); // 내림차순 정렬

			
			
			answer = Integer.toString(dSortt.get(0).getCourseScore(0)+dSortt.get(0).getCourseScore(1));		
		
		
		return answer;
	}
	
	public String solveQuiz3() {
		String answer = null;
		
		ArrayList<Integer> ttScore = new ArrayList<>();	
	
		for(Student std : dataList) {	
			int scoreP = std.getCourseScore(1)+std.getCourseScore(2); //영어 + 수학
			
			if(scoreP>=120) {
 	
				switch(std.getAchv()) { //성취도를 받음
				
				case "A" :
					ttScore.add(std.getTotalScore() + 5);
					break;
				case "B" :
					ttScore.add(std.getTotalScore() + 15);		
					break;
				case "C" :
					ttScore.add(std.getTotalScore() + 20);	
					break;				 				
				}
			
			}	
			
		}
		
		Collections.sort(ttScore, Collections.reverseOrder()); // 내림차순 정렬
		
//		int total = 0;					// 총점 + 점수 포인트가 가장 높은 점수 확인
//		for(Integer tt : ttScore) {
//			total = total + tt;
//			
//			System.out.println("총점 + 점수 포인트 : " + tt );
//		}
		
		answer = Integer.toString(ttScore.get(0));
		
		return answer;
	}

	public String solveQuiz4() {
		String answer = null;
		
		
		ArrayList<Integer> ttScore = new ArrayList<>();	
	
		for(Student std : dataList) {	

				switch(std.getLocalCode()) { //성취도를 받음
				
				case "A" :
					ttScore.add(std.getCourseScore(0) + 5);
					break;
				case "B" :
					ttScore.add(std.getCourseScore(0) + 10);		
					break;
				case "C" :
					ttScore.add(std.getCourseScore(0) + 15);	
					break;				 				
				}
										
		}
		
		int count = 0;
		for(Integer itt : ttScore) {	
			
			if(itt >= 50) {
//				System.out.println("국어 + 점수 50이상 : " + itt); // 50이상인 정보 확인
				
				count++;
			}
									
		}
		
		answer = Integer.toString(count);
		
		return answer;
	}
}
