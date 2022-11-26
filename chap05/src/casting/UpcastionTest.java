package casting;
//up down casting 사용법 / 다형성을 사용할떄 많이 사용한다
class Person{
	String name;
	String id;
	
	public Person(String name) {
		this.name = name;
	}
}
class Student extends Person{
	 String grade;
	 String department;
	 
	 public Student(String name) { //생성자를 만들어 둬야 위 클래스 상속으로 인한 오류가 발생하지 않는다(기본 생성자 호출(디폴트))
		 super(name);//기본적으로 super()을 호출하지만 그 값은 없기 떄문에 이렇게 존재하는 매개변수를 던져 두어야 한다
	 }
}

public class UpcastionTest {

	public static void main(String[] args) {
		//upcasting
		Person person; // person을 미리 변수로 지정  
		Person student = new Student("장성호");
		person = student; // upcasting를 해주고 값을 변화 가능하다
//		Person person = new Student("장성호"); - 이렇게 값을 입력하여도 결과는 똑같이 나온다
		person.name="장동건";
		System.out.println(person.name); //upcasting은 위로 올라가게 해준다 그러나 기존에 가졌던 특성 grade, department는 쓸 수 없게 된다
		 //학생은 사람이기 때문에 형변환없이 바로 업캐스팅이 가능하다
		System.out.println(student.name);// 둘다 장동건 출력
		
		//downcasting
		Person person02 = new Student("이성규");//upcasting
		Student student02;
		student02 = (Student)person02; // downcasting = 반드시 타입 변환이 필요하다(사람이 무조건 학생이라는 것은 아니기 때문에 형 변환을 해주어야 한다)
		System.out.println("student == "+student02.name);
		System.out.println("student == "+person02.name);
		
		Person person04 = new Person("뭐야");
		System.out.println(person04.name);
		

		//다형성을 위해 사용
		
		
		
	}

}
