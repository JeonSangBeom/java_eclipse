package Exec;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int myArr[];
		myArr=new int[10];
		//int myArr[] = new int[10]; 이렇게 쓸 수도 있다
		System.out.println("양의 정수 10개를 입력하시오>>");
		for(int i=0;i<myArr.length;i++) {
			myArr[i]=scanner.nextInt();
		}
		System.out.println("3의 배수는:");
		for(int j=0;j<myArr.length;j++) {
			if(myArr[j]%3==0)
				System.out.println(myArr[j]+"");
		}
		scanner.close();
	}

}
