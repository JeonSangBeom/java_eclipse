package Exec;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int myArr[];
		myArr=new int[10];
		//int myArr[] = new int[10]; �̷��� �� ���� �ִ�
		System.out.println("���� ���� 10���� �Է��Ͻÿ�>>");
		for(int i=0;i<myArr.length;i++) {
			myArr[i]=scanner.nextInt();
		}
		System.out.println("3�� �����:");
		for(int j=0;j<myArr.length;j++) {
			if(myArr[j]%3==0)
				System.out.println(myArr[j]+"");
		}
		scanner.close();
	}

}
