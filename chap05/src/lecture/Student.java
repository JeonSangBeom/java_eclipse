package lecture;

import java.util.Scanner;

//상속 사용법
public class Student extends Person{//Person을 상속 받겠다
	public Student() {
		System.out.println("나는 Person을 상속받은 학생 클래스");
	}
	public void set() {
		this.age = 30; // this.를 쓰면 person에서 얻어올 수 있는 값들을 볼 수 있다 (안써도 상관은 없다)
		setWeight(80); //private를 set으로 변환하여 사용한거기 때문에 앞에 set과 메서드이기 때문에 괄호를 사용해 준다
		name = "전상범";
		height=180;		
	}
	
	public static void main(String[] args) {
		//기본 사용법 연습
		Person p = new Person();
		Person a = new Person("상");
		System.out.println(a.name);
		
		Person n = new Person("보",1);
		System.out.println(n.name+n.age);
	
		
		//사용법 연습
		Person poo[] = new Person[3];
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<poo.length;i++) {
			System.out.println("이름을 입력하시오");
			String name = scanner.nextLine();
			poo[i] = new Person(name);
		}
		for(int i=0; i<poo.length;i++) {			
			System.out.println(poo[i].name);
		}
		scanner.close();
	}

}
