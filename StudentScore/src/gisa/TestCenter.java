package gisa;

import java.util.ArrayList;

import ScoreService.Student;

public class TestCenter {
	
	public static void main(String[] args) {
		//String path = "/resource/Abc1115.txt";
	}
	
	public void startTest() {
		System.out.println("시험지를 배부합니다.");
		
		ArrayList<StudentDTO> data = null;
		data = this.readyData();
		
		GisaQuiz quiz = new GisaQuiz(data);
		String answer = null;
		answer = quiz.solveQuiz1();
		this.submitAnswer(1, answer);
		answer = quiz.solveQuiz2();
		this.submitAnswer(2, answer);
		answer = quiz.solveQuiz3();
		this.submitAnswer(3, answer);
		answer = quiz.solveQuiz4();
		this.submitAnswer(4, answer);
		
		System.out.println("답안지를 모두 제출합니다.");
		System.out.println("시험을 종료합니다.");
	}
	
	private ArrayList<StudentDTO> readyData() {
		// TODO Auto-generated method stub
		return null;
	}

	private void submitAnswer(int num, String ansewer) {
		
	}

}
