package lecture;

public class MainThreadTest {
	public static void main(String[] args) {
		long id = Thread.currentThread().getId(); //currentThread - 현재 진행중인 Thread / id
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State state = Thread.currentThread().getState();
		System.out.println("현재 돌아가고 있는 Thread ID==="+id);
		System.out.println("현재 돌아가고 있는 Thread name==="+name);
		System.out.println("현재 돌아가고 있는 Thread priority==="+priority); // 1 ~ 10 까지 있을것(우선순위)  //5 - 처음엔 이정도에서 시작
		System.out.println("현재 돌아가고 있는 Thread state==="+state); //상태 - RUNNABLE
		//start()  //중지시킬때 방법 - interrupt(); while() return
	}
}
