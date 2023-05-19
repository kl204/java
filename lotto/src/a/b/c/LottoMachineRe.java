package a.b.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import one.two.three.LottoBall;

public class LottoMachineRe {
	// ArrayList로 로또볼에 대한 property 
	private ArrayList<LottoBall> balls;
	
	public LottoBall[] startMachine() {//로또 볼에 대한 배열로 만들어서 랜덤 수를 넣고 반환 해주기 위한 자료형,제네릭?
		LottoBall[] selectedBalls = new LottoBall[6];
		
		for(int i = 0; i<selectedBalls.length;i++) { //수를 비교할때 그냥 정수 6넣어서 하면 '하드코딩'이라고함, 최대한 함수 이용해서
			
			Collections.shuffle(balls);//섞어 주는 코드
			selectedBalls[i] = this.getBall(); 

			System.out.println(selectedBalls[i] +"이 선택되었습니다.");

			try {
				Thread.sleep(1500);// 일정간격
			} catch (Exception e) {
				// TODO: handle exception
			}
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
	//1개의 로또볼을 꺼낸다
	public LottoBall getBallOld() {
		//리턴할 볼에대한 property
		//startMachine에서 반환해줘야할 랜덤값 
		
		LottoBall ball = null;
		Random rnd = new Random();
		
		//중복처리를 한다.
		while(true) {
			//저장소에서 꺼낼 공 결정
			int index = rnd.nextInt(balls.size()); // nextInt로 왜 써야하는지? 랜덤함수 매개변수에 대한 내용?
			//공을 꺼낸다
			ball = balls.get(index);  //ArrayList의 get에 대한 내용: index의 값을 balls의 리스트에서 검색하여 가져옴, 
									// 무작위로 생성된 값이 balls의 리스트에 존재하는 이유는 이미 45개의 볼이 모두 존재하기 
									//때문에 무작위로 뽑아도 항상 존재하기 때문에 가져올 수 있음
			//꺼낸 공 중복 체크
			if(!ball.isSelected()) { // 따라서 중복의 제거를 하기 위해서 플래그가 따로 필요하게 됨. startMachine은 한번 실행 selectBalls[] 도 
									// 하나의 객체 이지만 각 배열안의 값들 하나 안에는 getBall의 LottoBall 타입의 ball 들이 하나하나 따로
									//생성되어 각 볼과 isSelected 쌍의 값을 가짐
				ball.setSelected(true);
				break;
			}
		}
		
		
		return ball;
	}
	
	public void setBall(ArrayList<LottoBall> balls) {
		this.setBall(balls);
	}
	/*
	 저장할 ArrayList Property
	 
	 로또머신 함수
	 매개변수 받아서 로또볼의 배열에 저장
	 리턴 배열
	 
	 게터
	 난수 생성해서 리턴 시켜줄 변수
	 중복체크
	 
	 세터
	 
	 */
	
	
	//실제 로또 방송에서 나오는것과 지금 이 코드의 차이? : 

}
