package lecture;
//상속자 호출법

//따로 부모 생성자 함수를 호출하지 않으면 무조건 default 생성자를 찾아서 호출
//super() 통해서 호출을 하지 않으면 기본적으로 default 생성자를 호출한다. ->puvlic A()
class A { // 위에 따로 클래스를 만들어 써도 된다 public(접근지정자)는 사용할 수 없다(임시로 만드는 것이기 때문)
	public A() {//클래스를 위에 따로 만들어 쓸 수 있는데 이런 것을 inner class 라고 한다
		System.out.println("나는 A 생성자 함수");//여기서 super()-기본호출시 불러온다/ 
		//생성자에서 괄호를 열고 닫는데 그것을 함수라 한다 그리고 보통 이것을 생성자 함수라 한다
	}
	public A(int x) { // 이렇게 생성자를 만들어 두면 위에 기본생성자를 지웠을떄 아래B()의 생성자에서 오류가 뜬다(아무것도 없을 때에만 디폴트 생성자가 호출되어 오류가 발생되지 않는다)
		System.out.println("나는 x를 매개변수로 하는 생성자 함수 A");
	}
}

//*class라는 설계도 안에 여러 속성을 기입가능(int, char, strong, double) -변수
//	생성자란 괄호가 있는 것을 보면 알 수 있듯이 함수이다. 클래스 안에서 메서드라 불리며 생성자로써 구체화 시키고 있는 것 - 함수
// 또 생성자는 리턴 타입이 없는 것으로 처음 생성할떄 생성해준다 (생성과 동시에 실행)

class B extends A {
	public B() { //여기서public B(5)를 호출하면 public A(int x)이것이 호출 된다(super(x)때문)
		System.out.println("나는 B 생성자 함수");
	}//매개변수가 없는 것을 호출할때는 이것을 호출한다
	public B(int x) {
		super(5); // 부모 생성자 함수 호출(필요한 것을 호출 가능) /만약 쓰지 않으면 기본 super();이 호출이 된다 현재 (5)를 썼기 때문에 A(int x)가 호출된다
		//기본 생성자를 호출할때 오류를 없애기 위해 이것 을 호출하게 만든다 
		System.out.println("나는 x를 매개변수로 가지는 생성자 함수 B");
	}
}
//상속을 받는 곳에 같은 기본 생성자 형식의 메서드가 존재한다면 부모쪽에 지워서는 안된다 그럴시 오류 발생(해결방법 super로 불러올 대상 바꿔주기)
class C extends B{
	public C() {
		System.out.println("나는 C 생성자 함수");
	}
}

public class ConstructorTest {
	public static void main(String[] args) {
		B b = new B(2);
		//출력
		//나는 x를 매개변수로 하는 생성자 함수 A
		//나는 x를 매개변수로 가지는 생성자 함수 B

	}

}
