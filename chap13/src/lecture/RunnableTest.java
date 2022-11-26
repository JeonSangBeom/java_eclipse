package lecture;
//Runnable ���� - implements�� ���
class TimerRunnable implements Runnable {
	int num = 0;
	@Override
	public void run() {
		while(true) {
			System.out.println(num);
			num++;
			try {
				Thread.sleep(1000);//�̰� Thread ��� �ʿ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class RunnableTest {
	public static void main(String[] args) {
		//run ��� �� 
		Thread tr = new Thread(new TimerRunnable());
		tr.start();
	}
}
