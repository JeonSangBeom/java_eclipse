package lecture;
//인터페이스와 상속 이용
public class IPhone7 extends Iphone implements MusicPhoneInterface{

	@Override
	public void play() {
		
	}

	@Override
	public void stop() {
		
	} //기존 아이폰 세팅이 되어 있을 경우 기존 것을 상속 시켜 사용하면된다
	  // 새로 구현 하여야 하는 부분만 implements 시켜주면 된다(extends이용)
	  // MusicPhoneInterface을 바로 implements시키면 Override는 6개가 뜸
		

	

}
