package a.b.c;

import java.util.ArrayList;
import java.util.Random;

import one.two.three.LottoBall;

public class LottoMachine {
	// ArrayList로 로또볼에 대한 property 
	private ArrayList<LottoBall> balls;
	
	public LottoBall[] startMachine() {//로또 볼에 대한 배열로 만들어서 랜덤 수를 넣고 반환 해주기 위한 자료형,제네릭?
		LottoBall[] selectedBalls = new LottoBall[6];
		
		for(int i = 0; i<selectedBalls.length;i++) { //수를 비교할때 그냥 정수 6넣어서 하면 '하드코딩'이라고함, 최대한 함수 이용해서
			
			selectedBalls[i] = this.getBall(); 
			
		}
		
		return selectedBalls;
	}
	
	public LottoBall getBall() {
		//리턴할 볼에대한 property
		//startMachine에서 반환해줘야할 랜덤값 
		
		LottoBall ball = null;
		Random rnd = new Random();
		
		//중복처리를 한다.
		while(true) {
			
			int index = rnd.nextInt(balls.size()); // nextInt로 왜 써야하는지? 랜덤함수 매개변수에 대한 내용?
			ball = balls.get(index);  //ArrayList의 get에 대한 내용
			if(!ball.isSelected()) {
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

}
