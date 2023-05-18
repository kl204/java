package a.b.c;

import java.util.ArrayList;

import one.two.three.LottoBall;

public class Studio {
	public static void main(String[] args) {
		//  실행하기 위해서는 studio 자체 생성을 먼저 한후 메소드를 사용 
		Studio sbs= new Studio();
		sbs.onAir(); //객체 생성을 했으니 객체 안에서 함수를 써야지
		
	}
	
	public LottoMachine ready() {
		LottoMachine machine = new LottoMachine(); // 메인함수 클래스있는 곳에는 property를 직접 생성을 피하기 위해 사용하는 클래스의 객체를 클래스 안에 생성해서 사용

		// 로또 볼 45개 준비를 위한 for문으로 ArrayList의 add
		ArrayList<LottoBall> balls = new ArrayList<LottoBall>();
		// setBall을 써서 machine 객체에 ArrayList로 된 balls property에 저장
		for(int i = 0;i<45;i++) {
			balls.add(new LottoBall(i+1));
		}		
		machine.setBall(balls);		
		return machine;  //machine 객체 반환
	}
	
	public void onAir() {
		
		//ready 함수를 쓰기 위해서 선언
		LottoMachine machine = this.ready(); // new 로 생성하지 않아도 되는건지?-> this로 이미 sbs 객체를 통하여 machine이 생성 되었기 때문에 그래서 아래의 macine.startMachine 쓸 수 있는것임
		
		//로또 볼을 쓰기 위한 로또머신 선언
		LottoBall[] balls = machine.startMachine();
		
		//로또 볼 출력을 위한 for문
		
		
	}
	/*
	  메인함수
	  동작함수
	  
	  레디함수
	  로또머신 함수 생성,리턴
	  
	  온에어함수(동작함수)
	  레디함수로 초기화
	  
	  */

}
