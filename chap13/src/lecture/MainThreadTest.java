package lecture;

public class MainThreadTest {
	public static void main(String[] args) {
		long id = Thread.currentThread().getId(); //currentThread - ���� �������� Thread / id
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State state = Thread.currentThread().getState();
		System.out.println("���� ���ư��� �ִ� Thread ID==="+id);
		System.out.println("���� ���ư��� �ִ� Thread name==="+name);
		System.out.println("���� ���ư��� �ִ� Thread priority==="+priority); // 1 ~ 10 ���� ������(�켱����)  //5 - ó���� ���������� ����
		System.out.println("���� ���ư��� �ִ� Thread state==="+state); //���� - RUNNABLE
		//start()  //������ų�� ��� - interrupt(); while() return
	}
}
