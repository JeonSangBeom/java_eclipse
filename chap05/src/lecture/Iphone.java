package lecture;

//�������̽� ��Ӽ� ��
//�������̽��� �߻�Ŭ���� �Ѵ� ���̸� ����� �����̴� - �ǹ����� �������̽��� �� ���� ���
//MobilePhoneInterface / PhoneInterface -> �ΰ����� �����°�

public class Iphone implements MobilePhoneInterface {

	@Override
	public void sendCall() {
	}
	@Override
	public void receiveCall() { //PhoneInterface ���� MobilePhoneInterface�� ��� �޾Ƽ� �ҷ��� �� 
	}
	@Override
	public void sendSMS() {
	}
	@Override
	public void receiveSMS() { //MobilePhoneInterface�� �����Ͽ� �ҷ��� ��
	}
}
