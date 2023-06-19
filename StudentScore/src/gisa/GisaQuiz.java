package gisa;

import java.util.ArrayList;

public class GisaQuiz {
	private ArrayList<StudentDTO> dataList;
	
	public GisaQuiz(ArrayList<StudentDTO> dataList) {
		this.dataList = dataList; //인자가 있는 생성자가 있을 때에는 인자가 없는 디폴트 생성자를 만들수가 없기 때문에 생성자에 매개변수를 주고
									// 생성자를 만들어 버리면 데이터를 써야만 하는 클래스에 대해서 데이터가 없는 상태에서 클래스를 생성하는
									// 상황을 방지해줄 수 있다.
	}
	
	public String solveQuiz1() {
		String answer = null;
		
		return answer;
	}
	
	public String solveQuiz2() {
		String answer = null;
		
		return answer;
	}
	public String solveQuiz3() {
		String answer = null;
		
		return answer;
	}
	public String solveQuiz4() {
		String answer = null;
		
		return answer;
	}
	

}
