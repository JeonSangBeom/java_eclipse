package lecture;
//Thread 사용법 / class를 밖에 빼서 사용
class MyTimer extends Thread {
	int num = 0;
	public void run() {//run() 제공되는 메서드
		while(true) {
			System.out.println(num);
			num++;
			try {
				sleep(10);//스레드 동작 시간을 정할 수 있다 1000이 1초 / 사용시 try catch 사용필요
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class TimerThread {
	public static void main(String[] args) {
		MyTimer timer = new MyTimer();
		timer.start();
	}
}
