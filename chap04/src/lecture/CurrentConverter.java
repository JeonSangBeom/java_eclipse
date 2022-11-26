package lecture;

public class CurrentConverter {
	private static double rate = 1100; // 고정환율
	public static double toDollar(double won) { 
		return won/rate;
	}
	public static double toKRWon(double dollar) {
		return dollar*rate;
	}
	//public static 이부분은 내가 정하는 것 그뒤 타입과 변수 그리고 매개변수가 중요
	
	//get or set를 이용하여 환률로 정해둔 private를 변경 할수 있게 해준다
	public static double getRate() {  //읽기 전용(이것만 있을경우 읽기만 가능하다)
		return rate;  
	}
	public static void setRate(double rate) {//읽기 쓰기 다 가능(변경 가능하게 해준다)
		CurrentConverter.rate = rate;
	}
}
