package lecture;
//Vector 사용법
import java.util.Vector;
public class VectorTest {
	public static void main(String[] args) {
		//collection은 무조건 객체만 - 기본타입 불가능 <> -> 이 안에 
		//갯수 정해놓고 쓰지 않음...
		//Vector 와 arrayList와 비슷하다 거의 유사
		//값이 정해져 있을때엔 배열이 좋고 그렇지 않을 경우엔 이렇게 vector나 arraylist를 사용하는 것이 좋다
		Vector <Integer> vec = new Vector<Integer>();//벡터를 생성 및 <타입설정>- <> = 제네릭 방식
		Vector <String> vec02 = new Vector<String>(); 
//		Vector <String> vec02 = new Vector<>(); // 이렇게 생략을 하여 사용하여도 상관 없다 - 자바에서 알아서 인식 
		vec.add(1);
		vec.add(2);
		vec.add(3);
		vec.add(10);
		vec02.add("장성호");
		vec02.add("김성호");
		vec02.add("이성호");
		vec02.add("박성호");
		vec02.add("최성호");
		vec02.add("오성호");
		System.out.println(vec.capacity());
		System.out.println(vec02.capacity()); //capacity - 10개 단위로 메모리를 추가 시키는 것
		for(int i=0;i<vec.size();i++) { // 한꺼번에 찾을때 -> length가 아닌 size를 사용하여야 한다
			System.out.println(vec.get(i));// 이렇게 get을 사용하여 찾을 수 있다
		}
		vec.add(2,1000);// 2째 index에 1000을 입력하겠다
		for(int i=0;i<vec.size();i++) {
			System.out.println(vec.get(i));
		}
		for(int i=0;i<vec02.size();i++) {
			System.out.println(vec02.get(i));
		}
	}
}

////출력
//10
//10
//1
//2
//3
//10
//1
//2
//1000
//3
//10
//장성호
//김성호
//이성호
//박성호
//최성호
//오성호