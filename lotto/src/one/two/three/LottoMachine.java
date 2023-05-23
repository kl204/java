package one.two.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


//로직클래스(Service 라고 불리는 것) 
public class LottoMachine {
	private ArrayList<LottoBall> balls;
	
	public LottoBall[] startMachine() {
		LottoBall[] selectedBalls = new LottoBall[6];
		
		for(int i = 0; i<selectedBalls.length;i++) { //수를 비교할때 그냥 정수 6넣어서 하면 '하드코딩'이라고함, 최대한 함수 이용해서
			
			Collections.shuffle(balls);//섞어 주는 코드
			selectedBalls[i] = this.getBall(); 

			/*
			System.out.println(selectedBalls[i] +"이 선택되었습니다.");

			try {
				Thread.sleep(1500);// 일정간격
			} catch (Exception e) {
				// TODO: handle exception
			}*/
		}
		
		return selectedBalls;
	}
	
	
	private LottoBall getBall() {
		LottoBall ball = null;
		Random rnd = new Random();
		
		int index = rnd.nextInt(balls.size()); // nextInt로 왜 써야하는지? 랜덤함수 매개변수에 대한 내용?
		ball = balls.remove(index);  //완전 꺼내므로 자동으로 중복처리

		return ball;
	}
	
	/*
	private LottoBall getBallOld() {
		LottoBall ball = null;
		Random rnd = new Random();
		
		//중복처리를 한다.
		while(true) {
			
			int index = rnd.nextInt(balls.size());
			ball = balls.get(index);
			if(!ball.isSelected()) {
				ball.setSelected(true);
				break;
			}
		}
		
		
		int num = (int)(Math.random()*45)+1;
		LottoBall ball = new LottoBall(num);
		
		
		return ball;
	}
	*/

	
	public void setBalls(ArrayList<LottoBall> balls) {
		this.balls =balls;
	}
}
