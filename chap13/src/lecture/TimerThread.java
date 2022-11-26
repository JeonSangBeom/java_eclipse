package lecture;
//Thread ���� / class�� �ۿ� ���� ���
class MyTimer extends Thread {
	int num = 0;
	public void run() {//run() �����Ǵ� �޼���
		while(true) {
			System.out.println(num);
			num++;
			try {
				sleep(10);//������ ���� �ð��� ���� �� �ִ� 1000�� 1�� / ���� try catch ����ʿ�
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
