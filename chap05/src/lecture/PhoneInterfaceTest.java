package lecture;

//클래스로 생성

public class PhoneInterfaceTest implements PhoneInterface { 
	// 추상클래스 처럼 extends를 쓰지 않고 implements를 써줘야 한다 그 외는 똑같이 PhoneInterfaceTest의 에러를 클릭하여 아래 오버라이드 메서드 자동 생성 필요

	@Override
	public void sendCall() {
		System.out.println("띠리리리링");
	}

	@Override
	public void receiveCall() {
		System.out.println("전화 왔어요...");
	}
	
	//따로 구현 하고 싶은 것이 있으면 이렇게 만들어도 상관 없다
	public void flash() {
		System.out.println("전화기에 불들어옴");
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
