package one.two.three;

import java.util.ArrayList;

public class Studio {
	
	
	public static void main(String[] args) {

		Studio sbs = new Studio();
		sbs.onAir();
		
		
	}
	
	//static은 클래스이고 클래스가 없으면 오브젝트: 이부분 무슨말인지?

	public LottoMachine ready() {			// 요즘은 property를 웬만하면 안만드려고 한다. 스레드 환경에서 변경 이슈가 있어서, 따라서 LottoMachine 타입을 쓴다. 리턴을 LottoMachine 으로 하려고
	//로또 머신과 로또 볼을 준비해야함				// property를 만든다는 말이 onAir 함수에서 new 사용해서 생성한다는 말인가?(궁금증) 그래서 사용한다는 말인가? 스레드와의 관계성은?
		LottoMachine machine = new LottoMachine();
		//머신 준비
		ArrayList<LottoBall> balls = new ArrayList<LottoBall>();
		//볼 준비
		for(int i = 0;i<45;i++) {
			balls.add(new LottoBall(i+1));
		}
		//머신에 볼 셋팅
		machine.setBalls(balls);
		return machine;
	}
	

	public void onAir() {
	//로또 머신에게 볼을 뽑도록 지시	

		System.out.println("지금부터 로또 추첨 방송을 시작합니다.");
		LottoMachine machine = this.ready();
		System.out.println("추첨을 시작합니다.");
		LottoBall[] balls = machine.startMachine();
		//balls의 내용을 출력
		System.out.println("제xxx회 로또 번호는 ");
		for(LottoBall ball : balls) {
			System.out.println(ball.getNumber() +"번");
		}
		System.out.println("이었습니다.");
		System.out.println("지금까지 시청해주셔서 감사합니다.\n 이것으로 제xxx회 로또추첨방송을 마치겠습니다.");
		
	}
	

}


//자바에서 카밀초기법을 사용함, 자바에서는 스네이크, 언더바 안쓴다.(언더바 표현은 상수를 표현할때 밖에 없다 왜냐하면 상수표기는 모두 대문자라서 대문자로 구분하는 표기법에서는 해당 안되기 때문)
//클래스는 무조건 앞글자 대문자