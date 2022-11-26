package lecture;
//Runnable 사용법 - implements를 사용
class TimerRunnable implements Runnable {
	int num = 0;
	@Override
	public void run() {
		while(true) {
			System.out.println(num);
			num++;
			try {
				Thread.sleep(1000);//이건 Thread 사용 필요
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class RunnableTest {
	public static void main(String[] args) {
		//run 찍는 법 
		Thread tr = new Thread(new TimerRunnable());
		tr.start();
	}
}
