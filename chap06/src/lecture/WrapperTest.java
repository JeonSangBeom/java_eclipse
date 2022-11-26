package lecture;
//Wrapper 객체 설명 - 기본 타입을 클래스화한 9개의 클래스 (총 8개의 객체가 있고 기본 타입의 값을 객체로 다룰 수 있게 함)

public class WrapperTest {
	
	public static void main(String[] args) {
		char ch01 = 'A';
		char ch02 = '4';
		char ch03 = 'F';
		String num = "10";
		
		
		//대문자를 소문자로 변경해주는 객체
		System.out.println("ch01 == "+Character.toLowerCase(ch01));
		//wrapper객체(클래스)에 static 메서드(parseInt)로 int로 바꿔서 출력할때 사용
		//static 메서드는 클래스 변수이기 때문에 앞에 바로 Integer라는 클래스를 바로 붙여 사용할수 있다
		System.out.println("num == "+Integer.parseInt(num) + 10);
		//isDigit - 문자 타입 형식이 맞는지 아닌지 true false 로 표시
		System.out.println("ch02 == "+Character.isDigit(ch02)); 
		
		
		Integer ten = 10; //Boxing (기본 타입(10)을 래퍼 타입(박스 - ten)으로 감싸는 것) - ten.으로 해서 클래스에 있는 static메서드(객체)를 불러와 쓸 수 있다(ex)parsiInt 같은 여러가지 객체 사용 가능)
		int intTen = ten;//un Boxing - 다시 박스를 풀어주는것 클래스 객체를 불러와 사용할 수 없다
		int age = Integer.parseInt("10");//자동으로 auto un boxing를 해주는 것  
		//age라는 값을 넘겨받았다고 했을때 string의 값으로 오기 때문에 이렇게 바로 변환도 가능하다

		
		int num02 = 10;
		Integer num02Obj = num02;  //boxing
		System.out.println("num02Obj=="+num02Obj);// 10 출력
		int sum = 10 + num02Obj;  //unboxing
		System.out.println("sum==="+sum);// 20 출력
		
		
	}
}
