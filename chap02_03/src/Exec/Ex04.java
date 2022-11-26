package Exec;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("소문자 알파벳 하나를 입력하시오>>");
		String s = scanner.next();
		char c = s.charAt(0);//해당하는 알파벳 첫번째 글자
		
		for(int i=0; i<=c-'a';i++) {
			for(char j='a';j<= c-i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		scanner.close();
	}

}
