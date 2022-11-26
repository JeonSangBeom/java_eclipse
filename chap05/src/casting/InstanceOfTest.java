package casting;
//instanceof 사용법
class Person01{}//슈퍼 클래스
class Student01 extends Person01{}
class Researcher extends Person01{}
class Professor extends Researcher{}// 이렇게 사용하면 Professor는 person01 researcher professor 이렇게 세가지에 해당이 되게 된다

public class InstanceOfTest {
	static void printPerson(Person01 p) { // static에 void라는 타입으로 printPerson의 이름을 가진 (person01클래스 타입(타입일뿐)의 p(매개변수))생성 
		//upcasting - Person01이 아닌 Studen01을 쓰면 그 아래 연관이 없는 Researcher과 Professor 의 타입은 쓸 수 없다
		if(p instanceof Person01) System.out.println("Person01"); 
		// 넘겨 받은 p 에서 Person01(객체-레퍼런스 타입)을 찾는 것 / instanceof는 객체 타입(기본타입에는 사용할 수 없다)과 같은지 확인 하는 것
		// P(이곳에 입력된 매개변수)에 Person01이라는 타입이 있는지 찾는 것(instanceof 역할)
		if(p instanceof Student01) System.out.println("Student01"); 
		if(p instanceof Researcher) System.out.println("Researcher"); 
		if(p instanceof Professor) System.out.println("Professor"); 
		System.out.println();//뛰어쓰기 용도
	}
	public static void main(String[] args) {
		System.out.print("new Student01()===>"); 
		printPerson(new Student01()); //함수 / new Student01의 객체를 생성
		System.out.print("new Researcher()===>"); 
		printPerson(new Researcher()); 
		System.out.print("new Professor()===>"); 
		printPerson(new Professor()); 
		
	}

}
