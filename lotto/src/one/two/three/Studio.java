// 로또 볼 강사님 기반 수정하는 코드 5/22 

// <실제 로또와 만든 코드의 차이점>
//1. 오름차순 정렬 (결과로 나온 볼들 정렬해서 출력)
//2. 중복처리(볼을 뽑는 볼 중에서 뽑은 볼에 대한 제거)
//3. 공이 섞임(45개의 볼 자체를 부여할때 순차가 아니라 섞여서 부여)
//4. 일정 간격으로 볼 추첨(하나의 공이 뽑히는 부분사이의 딜레이)
// 

//package one.two.three;		
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Studio {
//	
//	
//	public static void main(String[] args) {
//
//		Studio sbs = new Studio();
//		sbs.onAir();
//		
//		
//	}
//	
//	//static은 클래스이고 클래스가 없으면 오브젝트: 이부분 무슨말인지?
//
//	public LottoMachine ready() {			// 요즘은 property를 웬만하면 안만드려고 한다. 스레드 환경에서 변경 이슈가 있어서, 따라서 LottoMachine 타입을 쓴다. 리턴을 LottoMachine 으로 하려고
//	//로또 머신과 로또 볼을 준비해야함				// property를 만든다는 말이 onAir 함수에서 new 사용해서 생성한다는 말인가?(궁금증) 그래서 사용한다는 말인가? 스레드와의 관계성은?
//		LottoMachine machine = new LottoMachine();
//		//머신 준비
//		ArrayList<LottoBall> balls = new ArrayList<LottoBall>();
//		//볼 준비
//		for(int i = 0;i<45;i++) {
//			balls.add(new LottoBall(i+1));
//		}
//		//머신에 볼 셋팅
//		machine.setBalls(balls);
//		return machine;
//	}
//	
//
//	public void onAir() {		//<5/22 정렬 수정 필요>
//	//로또 머신에게 볼을 뽑도록 지시	
//
//		
//		System.out.println("지금부터 로또 추첨 방송을 시작합니다.");
//		LottoMachine machine = this.ready();
//		System.out.println("추첨을 시작합니다.");
//		LottoBall[] balls = machine.startMachine();
//		//balls의 내용을 출력
//		System.out.println("제xxx회 로또 번호는 ");
//		
//		//정렬이 필요한 공 배열에 담기
//		for(LottoBall ball : balls) {
//			int sortBall = ball.getNumber();			// 수정 필요 5/22
//			ballArr[] = sortBall;
//			
//		}
//		/*
//		for(int i = 0; i <balls.length ; i++ ) {
//			LottoBall ball = balls;
//			int sortBall = ball.getNumber();			// 수정 필요 5/22
//			ballArr[i] = sortBall;
//		}*/
//		
//		//정렬 로직(오름차순) 
//		int temp ;
//		LottoBall ballArr = balls[0];
//		
//		for(int i = 0; i <balls.length ; i++ ) {
//			for(int j = 0; j < balls.length ; j++) { // 11:30_강사님것 비교하여 고민해보기
//				if(ballArr[j] <= ballArr[j+1]) {
//					continue;
//				}else {
//					temp = ballArr[j];
//					ballArr[j] = ballArr[j+1];
//					ballArr[j+1] = temp;
//				}
//				
//			}
//		}
//		
//		/*
//		//정렬로직(ver.강사님)
//		LottoBall target = balls[0];
//		for(int i = 0; i <balls.length;i++) {
//			for(int j=i+1;i<balls.length;j++){
//			if(target.getNumber()>balls[j].getNumber()) {
//				LottoBall temp = balls[i];
//				balls[i] = balls[j];
//				balls[j] = temp;
//			}
//			}
//		}*/
//			
//		//Arrays.sort(ballArr);// 로또볼 정렬
//
//		
//		
//		//balls의 내용을 출력
//		for(LottoBall ball : balls) {
//			System.out.println(ball +"이 선택되었습니다.");
//
//			try {
//				Thread.sleep(1500);// 일정간격
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//		
//
//		
//		/*
//		for(int i = 0; i <balls.length ; i++ ) {
//			
//			System.out.println(ballArr[i] +"번");
//
//		}
//		
//		
//		for(LottoBall ball : balls) {
//		
//			System.out.println(ball.getNumber() +"번");
//		}
//		*/
//		System.out.println("이었습니다.");
//		System.out.println("지금까지 시청해주셔서 감사합니다.\n 이것으로 제xxx회 로또추첨방송을 마치겠습니다.");
//		
//	}
//	
//
//}
//
//
////자바에서 카밀초기법을 사용함, 자바에서는 스네이크, 언더바 안쓴다.(언더바 표현은 상수를 표현할때 밖에 없다 왜냐하면 상수표기는 모두 대문자라서 대문자로 구분하는 표기법에서는 해당 안되기 때문)
////클래스는 무조건 앞글자 대문자