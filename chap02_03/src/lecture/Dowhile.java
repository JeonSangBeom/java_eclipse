package lecture;

public class Dowhile {

	public static void main(String[] args) {
		//a~z
				char ch = 'a';// 작은 따옴표를 사용 
				do {
//					System.out.println("나는 dowhile입니다. 우선 한번 실행합니다. 그리고 조건이 맞으면 반복문을 종료합니다.");
					System.out.println(ch);
					ch= (char)(ch+1); //큰 박스엔 작은걸 넣어도 되지만 작은건 큰 박스에 넣게 되면 캐릭터 변수를 변형 시켜줘야한다
				}while(ch <= 'z'); //1.do 실행 2. 조건(while)이 맞으면 그뒤 계속 실행한다
			}
}
