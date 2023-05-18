package one.two.three;

import java.util.ArrayList;
import java.util.Random;


//로직클래스(Service 라고 불리는 것) 
public class LottoMachine {
	private ArrayList<LottoBall> balls;
	
	public LottoBall[] startMachine() {
		LottoBall[] selectedBalls = new LottoBall[6];
	
		for(int i = 0; i<selectedBalls.length;i++) {
			
			selectedBalls[i] = this.getBall(); 
			
		}
		
		return selectedBalls;
	}
	private LottoBall getBall() {
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
		
		/*
		int num = (int)(Math.random()*45)+1;
		LottoBall ball = new LottoBall(num);
		*/
		
		return ball;
	}
	
	public void setBalls(ArrayList<LottoBall> balls) {
		this.balls =balls;
	}
}
