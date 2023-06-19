package baseball;

public class BallMacher {
	
	public Client client = new Client();
	public BallProvider provider = new BallProvider();
	
	
	public boolean matching() {
		int strike = 0;
		int ball = 0;
		int out = 0;
		
		int[] clientBalls = client.input();
		int[] computerBalls = this.provider.getBalls();

		if(clientBalls == null) {
			return false;
		}
	
		System.out.print("입력한 숫자 : ");
		for(int i=0; i< computerBalls.length; i++) {
			System.out.print(clientBalls[i]);
		}
		System.out.println();
		System.out.print("제공된 숫자 : ");
		for(int i=0; i< computerBalls.length; i++) {
			System.out.print(computerBalls[i]);
		}
		System.out.println();
		
		for(int i = 0 ; i < 4 ; i++) {
			if(clientBalls[i]!= computerBalls[i]) {
				for(int j = 0; j < 4 ; j++) {
					if(clientBalls[i]== computerBalls[j]) {
						ball++;
						out--;
					}else continue;
				}
				out++;

			}else {
				strike++;
			}
		}
		
		if(strike == 4) {
			System.out.println("4스트라이크입니다!");
			return false;
		}
		
		System.out.println("ball : "+ball);
		System.out.println("out : "+out);
		System.out.println("strike : "+strike);
		
		return true;

		

	}

}
