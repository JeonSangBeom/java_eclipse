package lecture;
//static 설명
public class StaticSampleTest {

	public static void main(String[] args) {
		StaticSample st01;//만들고
		StaticSample st02;
		st01 = new StaticSample();// 선언 (같이 안쓰고 따로 쓸때)
		st01.n = 5;
		st01.g();
		//static = 전역 변수, 전역 메서드
		System.out.println("st01 m=="+StaticSample.m); //클래스 네임으로 접근하는 것은 전역변수만 된다(보통 그래서 객체로 안하고 클래스 네임으로 접근하여 많이들 사용한다)
		System.out.println("st01 n=="+st01.n);
		st02 = new StaticSample();
		st02.n= 1000;
		st02.f();// st02를 바꿔도 전역변수는 공유의 개념이기 때문에 다 같이 바뀐다
		System.out.println("st01 m=="+StaticSample.m);
		System.out.println("st02 m=="+StaticSample.m);
	}
}
