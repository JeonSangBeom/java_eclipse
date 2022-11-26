package practice;

import java.util.Scanner;

public class Chap0611 {
	public static void main(String[] args) {
		System.out.println("문장을 입력하세요...>>");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine(); // 명령어 입력 받기
		StringBuffer sb = new StringBuffer(str);//StringBuffer 생성
		// i love java
		//명령 : love!hate ====> i hate java // love를 hate로 바꾸라는 뜻
		//tokens= [love, hate] - love!hate가 저렇게 두개로 들어가게 될 것(tokens를 사용하면)
		while(true) {
			System.out.println("명령 : (!를 이용하여 문장 바꾸기) ");
			String command = scanner.nextLine();
			if(command.equals("그만")) {// 비교했을때 입력한 것과 그만이 나오면 종료 break
				System.out.println("종료합니다.");
				break;
			}
			String tokens[] = command.split("!"); // !로  두개로 분리한 후 tokens에 넣기 배열로
			System.out.println("tokens[0] = "+tokens[0].length());
			if(tokens.length!=2) { // 무조건 두개만 들어가게 2가 아니라면 조건 걸기(문장 길이는 상관이 없다)
				System.out.println("잘못된 명령입니다.");
			} else {
				int start = sb.indexOf(tokens[0]);//문장이 들어가는 첫번째가 필요하기 때문에 start로 변수 만들어주기 
				//tokens[0](변경할 문장)위치 전까지를 찾아 그 위치의 인덱스 값을 리턴
				sb.replace(start, start+tokens[0].length(), tokens[1]);//replace는 시작과 끝을 찾아 세번째 나온 것으로 바꿔라
				//변경할 문장의 위치 값인 start / start + tokens[0].length() - 변경될 문장의 길이도 계산하여 그 위에 새로운 문자을 넣기
				System.out.println(sb);// 그냥 입력하여도 가능
				System.out.println("start = "+start);
			}
		}
	}
}






