package lecture;

import java.util.Scanner;

public class While {
	//순서가 없을때 많이 사용 / 순서가 있을때에는 for문을 많이 사용한다
		public static void main(String[] args) {
			int num=10;
			int i = 0;
			int sum = 0;
			//정수를 여러개 입력받아서 평균을 구하라. -1을 입력하면 종료된다.
			Scanner scanner = new Scanner(System.in);
			System.out.println("점수를 입력하시오. 마지막에 -1을 입력하면 평균을 보여드립니다.");
			num = scanner.nextInt();// nextInt 정수를 입력받아 들어올때 사용
			while(num!=-1) { // 빠져나갈 수 있는 것을 입력해 줘야한다 아닐 경우 무한 반복
				System.out.println("나는 -1을 입력받을때까지 계속 일을 수행하는 while입니다.");
				sum+=num; // 입력한 값 다 더하기
				i++; // 갯수 
				num = scanner.nextInt();
//			while(i<10) {
//				System.out.println("나는 10보다 작을때까지 뭔가를 수행하는 while 입니다");
//			i++;
			}
			System.out.println("당신은 "+i+"개 입력하였고 평균은 "+sum/i+"입니다");
			scanner.close();
		}

	

	//public static void main(String[] args) {
//		int num=10;
//		int i = 0;
//		int sum = 0;
//		//정수를 여러개 입력받아서 평균을 구하라. -1을 입력하면 종료된다.
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("점수를 입력하시오. 마지막에 -1을 입력하면 평균을 보여드립니다.");
//		num = scanner.nextInt();
//		while(true) {
//			System.out.println("나는 -1을 입력받을때까지 계속 일을 수행하는 while입니다.");
//			sum+=num;
//			if(num==-1)break;
//			i++;
//			num = scanner.nextInt();
////		while(i<10) {
////			System.out.println("나는 10보다 작을때까지 뭔가를 수행하는 while 입니다");
////		i++;
//		}
//		System.out.println("당신은 "+i+"개 입력하였고 평균은 "+sum/i+"입니다");
//		scanner.close();
}
