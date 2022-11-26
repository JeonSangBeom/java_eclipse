package lecture;
//HashMap사용법 - 주로 검색할때 사용
import java.util.HashMap;
import java.util.Scanner;
//{키:값}을 주고 키로 값을 찾는다
public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String,String> dictionary = new HashMap<String,String>();//<키,값>
		dictionary.put("baby", "아기");//값을 입력할땐 put 사용 / string로 받기로 하였기 때문에 둘다 문자로 입력을 하여야 한다
		dictionary.put("love", "사랑");
		dictionary.put("apple", "사과");
		//System.out.println(dictionary.get("love")); // love라는 키를 받으면 사랑이 출력
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("찾을 단어를 입력해주세요. exit 쓰면 종료합니다.");
			String eng = scanner.nextLine(); // 입력 받을 것(키)
			if(eng.equals("exit")) break;
			String kor = dictionary.get(eng);// eng를 얻어올 값에 넣기 위에 정의한 값과 동일할 경우 출력
			if(kor==null) System.out.println("없는 단어입니다.");   // eng에 넣은 값이 다를 경우 
			else System.out.println(kor);
		}
	}
}
