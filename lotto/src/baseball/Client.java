package baseball;

import java.util.Scanner;

public class Client {
	
	private Scanner scanner = new Scanner(System.in);
	
	public int[] input() {
		System.out.print("4개의 숫자를 입력하시오 : ");
		String inputValue = scanner.next();
		int[] intValues = new int[4];		
		String[] intval = new String[4];
		
		if(inputValue.contains("기권")) {
			System.out.println("기권입니다.");
			return null;
		}
		
			for(int i = 0 ;i < inputValue.length();i++) {
		 intValues[i] = Integer.parseInt(String.valueOf(inputValue.charAt(i)));
		 intval[i] = String.valueOf(inputValue.charAt(i));
			}
			
			
				if() {
					System.out.println("중복되지 않은 값을 입력하세요.");
					this.input();			
				}
			
			

		
				
		return intValues;
	}

}
