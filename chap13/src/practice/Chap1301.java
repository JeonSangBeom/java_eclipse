package practice;

import java.util.Scanner;

class CountThread implements Runnable {
	@Override
	public void run() {
		System.out.println("스레드 실행 시작");
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(500);//0.5초마다 하나씩 생성
				System.out.print(i+"/");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("스레드 종료");
	}
}

public class Chap1301 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("아무키나 입력");
		scanner.nextLine();//한줄을 닫을떄
		Thread countThread = new Thread(new CountThread());
		countThread.start();
	}
}
