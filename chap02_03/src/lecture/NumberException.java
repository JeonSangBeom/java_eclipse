package lecture;

public class NumberException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strNum[] = {"23","12","3.14","100"};
		int i= 0;//catch 에서 값을 찾을 수 없어서 전역변수로 설정해 주어야 한다 /for문 안 int 지워주어야 한다
		try {	
		for(i=0;i<strNum.length;i++) { // 이곳에서 int를 선언하면 이 for문 블럭 안에서만 int를 사용할 수 있다
			int num = Integer.parseInt(strNum[i]);
			System.out.println("숫자로 바뀐 값은=="+num);
		}
		}catch(NumberFormatException e) {// 보통 NumberFormatException -> Exception 만 입력하여 사용한다
			System.out.println(strNum[i]+"는 정수로 변환이 되지 않습니다.");
			//e.printStackTrace(); =>Exception을 입력하여 사용한 경우 시스템 아웃 대신 사용
	}
}

}
