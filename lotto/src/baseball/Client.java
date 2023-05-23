package baseball;

import java.util.Scanner;

public class Client {
	
	private Scanner scanner = new Scanner(System.in);
	
	public int[] input() {
		int[] intValues = new int[4];		// 플레이어의 값을 정수로 저장 배열

		try {
		System.out.print("4개의 숫자를 입력하시오 : "); //플레이어의 값 문자열로 입력
		String inputValue = scanner.next();

		if(inputValue.contains("기권")) {				// 
			System.out.println("기권입니다.");
			return null;
		}
		
			for(int i = 0 ;i < inputValue.length();i++) {
		 intValues[i] = Integer.parseInt(String.valueOf(inputValue.charAt(i)));
		}
			
			for(int a = 0; a <inputValue.length(); a++ ) {
				for(int b = 0 ; b < inputValue.length(); b++) {
					if(a!=b && intValues[a] == intValues[b]) {
						System.out.println("중복되지 않은 값을 입력하세요.");
						intValues = this.input();
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException e) {
		    System.out.println("배열 인덱스를 벗어났습니다!");
		   // e.printStackTrace();
			intValues = this.input();
		}

			
			

		
				
		return intValues;
	}

}
