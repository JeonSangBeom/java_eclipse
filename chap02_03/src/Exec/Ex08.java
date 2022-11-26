package Exec;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 몇개?(1~99):");
		int n = scanner.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * 100 + 1);
		 // 중복인지 확인 하고 배열의 첫값부터 지금까지 돌았을때 같은 값잉 ㅣㅆㄷ
		for (int j = 0; j < i; j++) {
			if (arr[j] == arr[i]) {
				i--;
				break;
			}
			}
		}
		for(int i=0;i<n;i++) {
			if(i%10==9) {
				System.out.println(arr[i]+"");
				System.out.println();
			}else {
				System.out.println(arr[i]+"");
			}
		}
		
	}

}
