package lecture;

//Ŭ������ ����

public class PhoneInterfaceTest implements PhoneInterface { 
	// �߻�Ŭ���� ó�� extends�� ���� �ʰ� implements�� ����� �Ѵ� �� �ܴ� �Ȱ��� PhoneInterfaceTest�� ������ Ŭ���Ͽ� �Ʒ� �������̵� �޼��� �ڵ� ���� �ʿ�

	@Override
	public void sendCall() {
		System.out.println("�츮������");
	}

	@Override
	public void receiveCall() {
		System.out.println("��ȭ �Ծ��...");
	}
	
	//���� ���� �ϰ� ���� ���� ������ �̷��� ���� ��� ����
	public void flash() {
		System.out.println("��ȭ�⿡ �ҵ���");
	}
	public static void main(String[] args) {
		PhoneInterfaceTest phone = new PhoneInterfaceTest();
		phone.printLogo();
		phone.sendCall();
		phone.flash();
		phone.receiveCall();
		System.out.println(phone.TIMEOUT);
	}

}
