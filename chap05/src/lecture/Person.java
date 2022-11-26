package lecture;

public class Person {
	//접근제어자(지정자)의 종류
	private int weight;//외부에 공유 안된다 이런 필드를 사용시 getter/setter(메서드)을 사용해 주어야 한다
	int age; // 앞에 아무것도 쓰지 않을경우 default가 된다
	protected int height;
	public String name;
	
	//lombox( getter setter 을 편하게 사용할 수 있게 하는 라이브러리 - 나중에 설치하여 주로 사용한다)
	
	//생성자 함수(보통 초기화할때 만들어 준다 - 리턴 타입이 없다)
	public Person() {
		System.out.println("나는 사람"); 
	}
	
	//생성자 연습
	public Person(String name, int weight) {
		this.name = name;
		this.age = age;
		System.out.println("나는 사람"); //이런식으로 생성자 함수를 미리 정하면 사람을 정할때 뭄무게와 이름을 미리 정할 수 있다
	}	
	//연습
	public Person(String name) {
		this.name = name;
	}
	
	
	//alt+shift+s get or set누르면 자동 생성 가능
	public int getWeight() {//get은 불러 오는 거기 때문에 굳이 매개변수를 쓰지 않는다 / 또 값을 알려주는 역할을 하기 때문에 타입을 써주어야 한다
		return weight; //매개변수가 없기 떄문에 this를 생략하고 많이 쓴다
	}
	public void setWeight(int weight) { //값을 세팅할때 void 사용 set을 이용하여 private값을 불러와 사용하게 한다
		this.weight = weight; //private에서 바로 값을 불러올 수는 없지만 이러한 set메서드를 이용하여 값을 불러올 수 있다
	}	
	//getter(값을 받기만 함)/setter(값도 받고 바꿀 수 있을때 사용)
	

}
