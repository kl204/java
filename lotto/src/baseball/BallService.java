package baseball;

public class BallService {
	public static void main(String[] args) {
		BallService ballService = new BallService();
		ballService.gameStart();
	}
	
	public void gameStart() {
		BallMacher ballMaching = new BallMacher();
		
		
		while(ballMaching.matching()) {

		
		}
		System.out.println("게임을 종료합니다!");
	}


}
