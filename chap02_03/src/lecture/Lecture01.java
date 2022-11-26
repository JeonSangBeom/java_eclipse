package lecture;

public class Lecture01 {
	public static void main(String[] args) {
		//클래스는 반드시 첫번쨰는 대문자로 사용하여야 한다
		//자바 반복문 for, while, do while
		//System.out.println("Hello World"); / sysout만 치고 엔터치면 나온다
		//자료형 - int num = 10;, double = 10.0;(정수) , char = 'a' , boolean(true,false), String ="sdfsd
		int sum = 0;
		for (int i = 0; i <= 10; i++) {
			sum = sum + i; // 1, 3, 6, 10, 15, 21 
			System.out.print(i);
			if(i==10) {
				System.out.print("=");
			}else {
				System.out.print("+");
			}//1+2+3+4+5+6+7+8+9+10=55
		}
		System.out.println(sum);
	}

}

