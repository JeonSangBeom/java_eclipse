import java.util.Scanner;

public class GradeSwitch {

	public static void main(String[] args) {
		System.out.println("점수를 입력하세요");
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		String result = null;
		switch(score/10) {
		// 조건 스코어를 10으로 나눈다 정수이기 때문에 뒷자리 소숫점의 크기와 상관 없이 앞 숫자로 계산 79 = 7
		case 10:
//			result = "A"; - 9 와 결과가 같을 경우 생략 가능
//			break;  - 써줘야 만족되는 순간에 멈춰준다
		case 9:
			result = "A";
			break; 
		case 8:
			result = "B";
			break;
		case 7:
			result = "C";
			break;
		case 6:
			result = "D";
			break;
		default: // 나머지일 때
			result = "F";
		}
	
		System.out.println(result);
		scanner.close();
	}

}
