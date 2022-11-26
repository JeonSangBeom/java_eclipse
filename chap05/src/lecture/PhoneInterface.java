package lecture;

//�������̽� ����
//��� public�� �ַ� ��� / ��ü ���� �Ұ� / �߻� �޼��� abstract ���� ���� / �������̽��� ���� �ձ� ����(���ó��)
//new -> interface �� ����

public interface PhoneInterface {
	final int TIMEOUT= 10000;  //����� ���� �� ������ �׻� �빮�ڷ� ���°� �����̴� / ��ȭ�� ���� ������ �ð� 10000-10��
	public void sendCall();//��ȭ �ɼ� �־�� �Ѵٴ� ���� �˸��� ���� / �߻�Ŭ������ abstract�� ���� �ϰ�� �Ȱ���
	public void receiveCall();//��ȭ�� ���� �� �ְ�
	public default void printLogo() {    //public�� �� ���� ���� / default - �������̽� �ȿ� ������ �ϰ� ���� �� ���(���� ��� ����)
		System.out.println("---Phone---");
	}
}
