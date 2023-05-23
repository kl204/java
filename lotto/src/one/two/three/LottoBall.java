package one.two.three;

//데이터클래스(DTO/VO): 문제를 해결하는 정보를 가지고 있다. 은닉성을 나타내는 대표적 클래스
// 은닉성 : 데이터는 숨기고 메소드를 통해서 해결
public class LottoBall {// 
	private int number;
	private boolean isSelected; // 자기책임성의 원칙(한가지 클래스에서는 한가지 일만 한다), 볼의 중복성 자체는 볼 자체에서 해결해야한다.
								//즉, 볼의 숫자와 뽑혔는지에 대한 플래그를 가지고 있다면 자제 충복성 해결이 가능하다.
								// 위와 같은 변수들을 부르는 용어로는 필드,Property 라고 불린다. 예전에는 멤버변수 등으로 불렸다.
	
	public LottoBall(int number) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	
	/*
	public void setNumber(int number) { 공의 숫자이기 때문에 private로 바꾸거나 set(수정)을 사용하지 않도록 한다.
		this.number = number;t
	}
	*/
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public String toString() {
		return String.valueOf(this.number);//this.number+""
	}
	
}
