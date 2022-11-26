package lecture;
//synchronized���� - ���� ���
class SharedBoard {
	private int sum = 0;//�⺻ ��
	synchronized  public void add() {//synchronized - ���������� �۵�
		int current = sum;
		Thread.yield();// ���� ���� ���� ������ �纸�ϰ�
		current+=10;
		sum = current;
		System.out.println(Thread.currentThread().getName() + " : "+sum);//���� �������� �̸�
	}
}
class StudentThread extends Thread{
	private SharedBoard board;
	public StudentThread(String name,SharedBoard board) {
		super(name);//�θ� ������ ȣ��
		this.board = board;
	}
	public void run() {//10�� �ݺ�
		for(int i=0;i<10;i++) board.add();
	}
}
public class SyncTest {
	public static void main(String[] args) {
		SharedBoard sharedBoard = new SharedBoard();
		Thread student01 = new StudentThread("����", sharedBoard);
		Thread student02 = new StudentThread("�ʴ�", sharedBoard);
		student01.start();
		student02.start();
	}
}
