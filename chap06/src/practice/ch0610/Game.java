package practice.ch0610;

import java.util.Scanner;

class Player {
	private String name;
	private Scanner scanner = new Scanner(System.in);
	public Player(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public boolean turn() {//turn을 하면 세개가 찍히고 세개가 나오면 이기는 것ㅇ을 목적으로 생성
		System.out.println("["+name+"] : <Enter>");
		scanner.nextLine();//nextLine - enter 누를때 다음으로 넘어가게 하는 방법
		int nums[] = new int[3];
		for(int i=0;i<3;i++) {
			nums[i] = (int)(Math.random()*3+1); // 0이상 3미만의 랜덤 숫자 뽑기라 +1 및 int로 탭변화를 해주어야 한다
		}
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+"   "); // 위의 랜덤 값을 하나씩 출력 (하나씩 출력 후 "   "여백 생성)
		}
		boolean result = true; // 우선 true로 선언
		for(int i=1;i<nums.length;i++) {// i=0은 어차피 같을 것이기 때문에 1로 해주어도 상관이 없다(반복문을 하나라도 줄이기 위해 이렇게 사용
			if(nums[0]!=nums[i]) { // 첫번째와 나머지 비교 하는 방법 하나라도 다르면 false 주기
				result = false;
				break;
			}
		}
		return result;
	}
}

class SameNumerGame { // 게임 생성
//	private Player playerList[] = new Player[3];
//	private Scanner scanner = new Scanner(System.in);
//	public SameNumerGame() { // 생성자 함수 생성 가장 먼저 실행이 되는 것
//		System.out.println("참석자 세명을 입력하세요");
//		for(int i=0;i<playerList.length;i++) {
//			playerList[i] = new Player(scanner.nextLine());
//		}
//	}
	//숫자를 정하지 않고 사용자가 정하는 법
	private Player playerList[]; 
	private Scanner scanner = new Scanner(System.in);
	public SameNumerGame() { // 생성자 함수 생성 가장 먼저 실행이 되는 것
		System.out.println("게임에 참여할 참석자 수를 입력하세요");
		int total = scanner.nextInt();
		scanner.nextLine(); //이걸 써주지 않으면 줄바꿈을 해주지 않아서 바로 한칸 뛰어 반복문으로 넘어가 오류가 발생한다
		playerList = new Player[total];
//		System.out.println(playerList.length);
		for(int i=0;i<playerList.length;i++) {
			System.out.print(i+1 +"번째 선수 이름 입력 >>");
			playerList[i] = new Player(scanner.nextLine());
		}
	}
	public void run() { // 돌아가는 메서드 생성
		int i=0;// 순차적으로 시작을 하여야 하기 때문에 미리 선언
		while(true) {
			if(playerList[i].turn()) {
				System.out.println(playerList[i].getName()+"님이 이겼습니다.");
				break;
			} else {
				System.out.println(playerList[i].getName()+"님이 아쉽습니다.");
				i++;// 다음 순차의 사람이 해야하기 때문에 i를 증가시켜준다
				i=i%playerList.length;//범위를 벗어 나지 못하게 i의 갯수와 length의 갯수가 같아지면 0이 되어 다시 처음부터 실행이 된다
			}
		}
	}
}

public class Game {
	public static void main(String[] args) {
		SameNumerGame game = new SameNumerGame();
		game.run();
	}
}




