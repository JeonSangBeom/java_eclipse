package lecture;

//인터페이스 구현
//상수 public로 주로 사용 / 객체 생성 불가 / 추상 메서드 abstract 생략 가능 / 인터페이스로 구멍 뚫기 가능(상속처럼)
//new -> interface 로 생성

public interface PhoneInterface {
	final int TIMEOUT= 10000;  //상수를 만들 수 있으나 항상 대문자로 쓰는게 관례이다 / 전화를 끊어 버리는 시간 10000-10초
	public void sendCall();//전화 걸수 있어야 한다는 것을 알리기 위해 / 추상클래스와 abstract를 제외 하고는 똑같다
	public void receiveCall();//전화를 받을 수 있게
	public default void printLogo() {    //public은 다 생략 가능 / default - 인터페이스 안에 구현을 하고 싶을 때 사용(몸통 사용 가능)
		System.out.println("---Phone---");
	}
}
