package baseball;

import java.util.Random;

public class BallProvider {
	private Random rnd = new Random();
	private int[] balls;
	
	public BallProvider() {
		this.balls = makeBall();
	}
	
	private int[] makeBall() {
		int[] balls= new int[4];
		
		for(int i =0 ; i < 4 ; i++) {
			int ball = rnd.nextInt(9);
			if(ball == 0 && i ==0) {
				i--;
				continue;
			}
			balls[i] = ball;
		}
		
		return balls;
	}
	
	public int[] getBalls() {
		return this.balls;
	}
}
