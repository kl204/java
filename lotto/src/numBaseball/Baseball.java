package numBaseball;

import java.util.ArrayList;
import java.util.Set;

public class Baseball {
	private ArrayList<Integer> playerBall = new ArrayList<>();
	
	public ArrayList<Integer> setBall() {
		
		ArrayList<Integer> setBalls = new ArrayList<>();
		
		//Random rnd = new Random();
		//int index = rnd.nextInt();
		while(true) {
			if(setBalls.size() < 4) {
					int rnd = (int)Math.random();//math.random은 double 형을 리턴한다. 위의 math에서 쓰는 랜덤함수는 범위 지정 가능하다
					int rndBall = (rnd*9)+1;// 1~9까지의 랜덤 수
		
					if(setBalls.contains(rndBall)) {
						continue;
					}else {
						setBalls.add(rndBall);

					}
		
			}else break;
		}
		
		
		
		return setBalls;
		
	}
	
}
