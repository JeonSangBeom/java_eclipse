package lecture;

//인터페이스 상속설 명
//인터페이스나 추상클래스 둘다 명세이며 약속의 개념이다 - 실무에선 인터페이스를 더 많이 사용
//MobilePhoneInterface / PhoneInterface -> 두가지를 가져온것

public class Iphone implements MobilePhoneInterface {

	@Override
	public void sendCall() {
	}
	@Override
	public void receiveCall() { //PhoneInterface 에서 MobilePhoneInterface이 상속 받아서 불러온 것 
	}
	@Override
	public void sendSMS() {
	}
	@Override
	public void receiveSMS() { //MobilePhoneInterface을 구현하여 불러온 것
	}
}
