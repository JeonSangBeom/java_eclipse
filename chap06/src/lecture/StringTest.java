package lecture;
//String에 대한 설명
public class StringTest {
	public static void main(String[] args) {
		String str01 = "abcd"; // 생성자 new 없이 바로 가능
		char strList [] = {'a','b','c','d'};
		String str02 =  new String(strList); //원래의 규칙 - 이렇게 사용할 시 값이 같아도 객체로 생성이 되어 다 나뉘어 진다 위의 방식으로 사용할시 두개를 따로 생성해도 값이 같으면 동일하게 출력
		String str03 = new String("a/b/cd"); // String 출력 방법 3가지
		String str04 = "   abcd      ";
		String subject = "크리스마스가 지나갔습니다. 우리는 왜 1월 3일 쉬지 않는 걸까요....";
		
		//비교시
		System.out.println("같은지" + str01.equals(str03)); //string는 안에 내용이 같으면 같은 걸로 출력이 된다 비교시 equals사용 필수
		
		System.out.println(str01.charAt(0)); //charAt()안에 입력하는 숫자에 따라 String에 나오는 글자 출력 / a 출력
		System.out.println(str01.contains("ab"));//contains - 포함 여부(ad같은 경우는 false 출력이 된다 - 비연결) / true 출력
		System.out.println(str01.length());// length - 총갯수 / 4 출력
		System.out.println(str03.split("/")[2]); //split("/") 안에 나온 문자에 맞춰 쪼갠 후 배열로 만든다. 그 뒤 [2] 에 있는 순서에 맞춰 출력/ cd 출력
		System.out.println(str04.trim().charAt(0)); //trim - 앞 뒤공백을 전부 없애 버린다 / trim을 안할시 아무것도 출력이 안된다 / a 출력
		
		System.out.println(str01+str02); // abcdabcd 출력
		System.out.println(str01.concat(str02)); // string 연거푸 출력시 위 두가지 방법 사용 //abcdabcd 출력
		System.out.println(subject.substring(0,10)+"..."); //substring - 출력 하는 인덱스 순서 및 개수(띄어쓰기 포함 /크리스마스가 지나갔... 출력
		
	}
}
