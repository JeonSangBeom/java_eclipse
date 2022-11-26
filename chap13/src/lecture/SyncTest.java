package lecture;
//synchronized사용법 - 순차 재생
class SharedBoard {
	private int sum = 0;//기본 값
	synchronized  public void add() {//synchronized - 순차적으로 작동
		int current = sum;
		Thread.yield();// 실행 중인 것이 있으면 양보하게
		current+=10;
		sum = current;
		System.out.println(Thread.currentThread().getName() + " : "+sum);//현재 스레드의 이름
	}
}
class StudentThread extends Thread{
	private SharedBoard board;
	public StudentThread(String name,SharedBoard board) {
		super(name);//부모 생성자 호출
		this.board = board;
	}
	public void run() {//10번 반복
		for(int i=0;i<10;i++) board.add();
	}
}
public class SyncTest {
	public static void main(String[] args) {
		SharedBoard sharedBoard = new SharedBoard();
		Thread student01 = new StudentThread("버미", sharedBoard);
		Thread student02 = new StudentThread("너니", sharedBoard);
		student01.start();
		student02.start();
	}
}
