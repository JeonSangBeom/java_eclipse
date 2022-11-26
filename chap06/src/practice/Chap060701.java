package practice;
// 입력한 단어 개수 확인
import java.util.Scanner;
import java.util.StringTokenizer;

public class Chap060701 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println(">>");
			String str =  scanner.nextLine();
			if(str.equals("그만")) break; // 문자열에 그만이 나오면 멈추기(equals - 문자 비교)
			//StringTokenizer st = new StringTokenizer(str," "); / 구분 StringTokenizer
			//System.out.println("입력하신 문장의 단어 갯수는 "+st.countTokens()); - countTokens 갯수 확인
			
			//다른 방법
			String words[] = str.split(" ");// 공백의 갯수 만큼 숫자를 세기 위해
			System.out.println("입력하신 문장의 단어 갯수는 "+words.length);
		}
	}
}
