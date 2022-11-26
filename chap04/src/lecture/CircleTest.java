package lecture;

public class CircleTest { //보통 클래스와 실행 함수를 이렇게 따로 만들어 사용한다
	// 같은 패키지에 있으면 임폴트를 하여 가져올 수 있다
	static void increase(Circle circle) { // static은 stack(기본함수는 전부stack에 뜬다-increase)의 값을 받아 쓸 수 없기 때문에 미리 static이라는 것을 정의 해 두어야 한다
		circle.radius++; //circle는 변수기 때문에 영향을 주지 않는다 여기서 쓰는 circle는 아무거나 써도 똑같은 결과가 나온다
		//Circle의 클래스 타입을 사용한 것은 그 해당 클래스 타입에서 있는 것만 사용하고 정의 할 수 있다는 뜻
	}
	
	// 객체를 할당하면 레펀런스 참조 / 기본타입의 변수는 복사된다.
	public static void main(String[] args) {
		Circle pizza = new Circle();  //객체 생성  (memory)  heap - 다른 클래스에 있기 때문에 이런 생성이 꼭 필요하다
		pizza.name="새우피자";
		pizza.radius=20;
		double area = pizza.getArea();
		System.out.println("피자의 이름은 "+pizza.name+"이고 반지름은 "+pizza.radius+"이고 면적은 "+area+"이다");
		
		
		increase(pizza); // static이 stack값을 받아 올때 위에 따로 static를 거론 하여야 하고 그렇게 됐을때 이텔릭체로 표현이 된다
		System.out.println("pizza.radius==="+pizza.radius);
		System.out.println();
				
		
		Circle donut = new Circle();
		donut.name = "던킨";
		donut.radius = 10;
		double area02 = donut.getArea();
		System.out.println("도넛의 이름은 "+donut.name+"이고 반지름은 "+donut.radius+"이고 면적은 "+area+"이다");
		
				
		
		Circle02 circle02 = new Circle02();
		//circle02.radius= 20; / circle 클래스에 따로 값이 정의가 되어 있지 않을 경우 따로 값을 정해 두어야만 작동한다(현재는 Circle02에 정의된 상태)
		double area03 = circle02.getArea();
		System.out.println(area03); // 면적이 1로 설정이 된 상태(Circle02에) = 3.14출력
		
		
		
		Circle02 circle03 = new Circle02(50,"바퀴"); // 50, "바퀴"중요 클래스에 정의한 매개변수와 위치가 같아야한다
		double area04 = circle03.getArea();
		System.out.println(area04+"==="+circle03.name);//7850.0 ==== 바퀴 출력
		
		
		
		//참조 설명
		Circle won ; //객체(배열도 포함)는 복사가 아닌 참조(ex)값의 링크를 가져온다/하나의 정의만 되어 있다)를 하기 때문에 아래 값을 하나를 바꾸면 모든게 따라 같이 바뀌어 진다 
		won = pizza;
		won.name = "동그라미";
		System.out.println(won.name+"===="+pizza.name); // 동그라미===동그라미 출력
		
		int num = 3; //기본 타입(인트 더블 스트링 등)은 복사가 되어 값을 도출한다
		int copyNum = num;
		copyNum=4;
		System.out.println(num+"==="+copyNum); //3===4 출력
		
		Circle circleArray[] = new Circle[5]; //Circle(또는 int같은)타입으로도 쓸수 있다 대신 앞뒤 맞춰줘야 한다(객체도 배열에 담아 쓸수 있다) 
		
		for(int i=0;i<5;i++) {
			circleArray[i] =  new Circle(i+1);// Circle(i+1) radious가 1부터 시작
			System.out.println(circleArray[i].getArea());
			// 3.14
			// 12.56
			// 28.26
			// 50.24
			// 78.5 출력
		}
	}
}
