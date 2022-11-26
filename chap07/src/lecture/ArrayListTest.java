package lecture;
//ArrayList사용법
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//기존 배열과 다른 점 - 배열 확장 (가변길이 제공해준다 / 데이터 변경 가능)
//순서를 통해서 값을 찾는 방식
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> strList = new ArrayList<String>();//<> - 다이아몬드 연산자라 불린다
		Scanner scanner = new Scanner(System.in);
		//while로 바꿔서 입력한 이름이 그만 들어오면 빠져나가서 입력한 이름들 다 출략해보기.
		//for(int i=0;true;i++) { -> while를 사용하지 않고 true로 써도 사용할 수있다
		while(true) {
			System.out.println("이름을 입력하세요.");
			String name = scanner.nextLine();
			if(name.equals("그만")) break;
			strList.add(name);
		}
		// 반복하여 입력한 이름 확인
		for(int i=0;i<strList.size();i++) { 
			String name = strList.get(i); // 값을 얻어오기
			System.out.print(name+"/");
		}
		// 가자아 긴 이름 확인법
		int longIdx = 0;//기존 값 하나 선언
		for(int i=0;i<strList.size();i++) {// 하나씩 반복하며
			if(strList.get(longIdx).length() < strList.get(i).length()) {// 기존 선언한 0의 길이와 입력한 이름의 길이를 하나씩 비교 하여
				longIdx = i; // 가장 긴 값 i를 longIdx에 넣는다
			}
		}
		
		System.out.println("제일 긴 이름은==="+strList.get(longIdx));
		
		//Vector ArrayList 처럼 순환 구조를 가지는 것은 Iterator를 가지고 있다  
		
		//Map은 순서없이 들어간다. 대신 이렇게 (키 : value) 두개의 값을 입력하여 사용한다
		//size를 출력하지 않고 반복문을 돌리는 법
		Iterator<String> it = strList.iterator(); 
		System.out.println(it.hasNext());// hasNext - 다음께 있으면 true반환  / 출력 true
		while(it.hasNext()) {//다음꺼가 있으면 반복(순환이 가능할때까지 뿌려준다)
			System.out.print(it.next()+"/");// 입력한 값 출력 위와 동일
		}
	}
}







