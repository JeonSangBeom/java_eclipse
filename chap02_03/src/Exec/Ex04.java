package Exec;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�ҹ��� ���ĺ� �ϳ��� �Է��Ͻÿ�>>");
		String s = scanner.next();
		char c = s.charAt(0);//�ش��ϴ� ���ĺ� ù��° ����
		
		for(int i=0; i<=c-'a';i++) {
			for(char j='a';j<= c-i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		scanner.close();
	}

}
