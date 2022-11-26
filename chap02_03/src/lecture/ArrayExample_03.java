package lecture;

import java.util.Scanner;

public class ArrayExample_03 {
	//배열을 5개짜리 배열을 입력받아서 만들고 평균 출력해보기
	public static void main(String[] args) {
		int arr[] = new int[5];
		int sum = 0;
		int total = arr.length;
		double avg = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println(total + "다섯개 숫자 정수 입력해 주시면 평균을 구해드립니다.");
		for (int i = 0; i < total; i++) {
			arr[i] = scanner.nextInt();
		} // 중괄호는 한줄일 때에는 안써도 된다
//		for (int j = 0; j < total; j++) {
//			sum += arr[j]; //  하나씩 더하기 위에 만들어둔 배열 값을
//		}
		for(int k : arr) { //forEach(자바스크립트에 있는) 와 같은 방식이다 k(임의로 정한 변수)
			sum+=k;
		}
		avg = sum / total;
		System.out.println("평균은" + avg);
		scanner.close();
		
		//string 반복 연습
		String fruits[] = {"apple","orange","banana","kiwi"};
		for(String item : fruits) {
			System.out.println(item+"=="); // 전부 뜬다
		}
	}
}
