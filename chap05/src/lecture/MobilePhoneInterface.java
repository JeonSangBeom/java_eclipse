package lecture;
//인터페이스 끼리 상속하는 법
//인터페이스 끼리 상속이 가능하다
public interface MobilePhoneInterface extends PhoneInterface {
	public void sendSMS();
	public void receiveSMS();
	void sendCall();
}
