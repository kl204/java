//내가 짠 숫자 야구게임 코드 완성 5/23일


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
