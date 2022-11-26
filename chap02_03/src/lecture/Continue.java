package lecture;

import java.util.Scanner;

public class Continue {

	public static void main(String[] args) {
		//정수 다섯개를 입력받아서 더하는 합 구하기
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 다섯개를 입력 하시면 양수의 합만 합을 구해드립니다 ");
		int sum = 0;
		for(int i=0;i<5;i++) {
			int num = scanner.nextInt();
			if(num<=0) continue;//조건을 만족하면 continue 는 건너뛰어준다 / break는 반복문 블럭을 빠져나가기
			sum+=num;
		}
		System.out.println(sum);
		//continue사용시 ex) 10 20 -30 -20 10 답은 = 40
		
	}

}
