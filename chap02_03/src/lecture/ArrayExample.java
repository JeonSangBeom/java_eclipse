package lecture;

import java.util.Scanner;

public class ArrayExample { //public - 접근 제어자(외부에 공개를 하느냐를 따지는 것)
	//class는 기본 타입(여러가지 타입(int 등등)들을 넣어두는 곳으로 보면 되고 그 안에 int같은 함수 및 변수를 쓸 수 있다(값을 바꾸고 싶어 할 수 있는 행동들을 정의해 놓는 곳
	//class 내부에 선언된 변수들을 속성(필드), 내부에서 선언된 함수들을 메서드라 한다 이러한 것들을 나중에 new(객체의 생성자 호출)라는 생성자를 통해 쓸 수 있다
	//클래스 네임은 대문자가 규칙이다
	//타입은 변수에 담기고 변수의 값을 바꾸고 싶거나 행동들을 정의해둔 곳
	
//배열
	public static void main(String[] args) {//메인이라는 함수(메서드)가 args라는 매개변수와 String라는 배열(속성)을 가지고 있다 
		//void 함수가 실행후 리턴을 할경우 다른 int()리턴 값을 써 두어야 한다 그렇지 않을 경우 void사용
		int arr[] = new int[10];// 배열 만드는 법 []는 앞이나 뒤나 상관 없다 뒤에가서는 ArrayList(넣고 빼기에 유용하다)를 더 쓰게 될 것
		// 미리 정해두면 그 이상은 쓸 수가 없다
		//생성자 기존에 정의되어 있는 것으로 new를 이용하면 처음 나타나는 것
		arr[0] = 10;
		arr[1] = 15;
		arr[2] = 17;
		arr[3] = 32;
		arr[4] = 80;
		System.out.println(arr[5]);// 0~9까지만 쓸 수 있다, 정해두지 않은 것을 입력시 0이 나온다
		int arr02[] = { 1, 2, 3, 100, 5, 4, 50 };// 갯수를 자유롭게 쓸 수 있다{}안에 정수만 써서 사용 가능
		System.out.println(arr02[3]);
		
		Scanner scanner = new Scanner(System.in);//new Scanner(System.in)스캐너를 구현(구현한 곳)
		int arr03 [] = new int[5];
		int total = arr03.length;
		int max = 0;
		System.out.println("숫자 "+total+"개를 입력하시오.");
		for(int i=0;i<5;i++) {
			arr03[i] = scanner.nextInt();
			if(arr03[i] > max) {
				max = arr03[i];
			}
		}
		System.out.println(arr03[2]); // 세 번째 수 출력하기
		System.out.println(max);// 제일 큰 수 출력하기
		
	}

}
