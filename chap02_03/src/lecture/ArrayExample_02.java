package lecture;

import java.util.Scanner;

public class ArrayExample_02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr03[] = new int[5]; // 배열 지정 = 배열 갯수 지정
		int total= arr03.length; //갯수의 자유를 줄때 사용
		int max =0;
		System.out.println("숫자"+total+"개를 입력하시오.");
		for(int i=0;i<total;i++) {
			arr03[i] = scanner.nextInt();
			if(arr03[i]>max) {
				max= arr03[i];
			}
		}
		System.out.println(arr03[2]); // 제일 큰 수 ㅇ출력하기
		System.out.println(max); 
	}

}
