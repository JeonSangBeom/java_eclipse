package practice;

import java.util.Scanner;
//사람 vs 컴퓨터 두개를 만들어서
//사람은 가위바위보를 키보드 눌러서 결정
//컴퓨터는 random()
class Gamer {
	private String name;//철수 또는 컴퓨터라는 이름을 가져야 하니까  생성
	private Scanner scanner = new Scanner(System.in); // 이름은 입력을 받아야 하니까 스캐너 생성
	public Gamer(String name) { // 생성자 함수로 이름을 받아오기
		this.name = name;
	}
	public String getName() { // 생성자 함수로 만들어진 것을 값을 바꿀 순 없지만 얻어 올수는 있게 get설정
		return name;
	}
	public int turn() { // 가위바위가 턴마다 리턴을 하여야하고 정수로 가기 때문에 int사용
		System.out.println(name+"[가위 : 1, 바위 : 2, 보 : 3] >> ");
		int result = scanner.nextInt(); // 입력한 값을 바로 리턴시켜준다 (그래서 result 변수에 그 값을 담아둔다)
		return result;
	}
}
class Computer extends Gamer { // 컴퓨터 가 게이머의 정보를 상속 받은 것
	public Computer(String name) {
		super(name);//슈퍼는 게이머를 가리킨다 슈퍼에서 네임을 상속 받아 가져온다
	}
	@Override
	public int turn() {
		int result = (int)(Math.random()*3)+1; // int로 타입 캐스팅을 해줘서 정수로 바꿔준다 뒤에 +1은 0부터 시작이기 때문
												//int는 Math.floor(floor은 리턴타입이 double이기 때문에 이것과 맞지 않다)와 같은 역할(소숫점을 전부 버려준다)
		return result;
	}
}
class RockPaperScissors {
	private String words[] = {"가위","바위","보"}; // 변수는 되도록 private 나중에 get the set을 하여 바꾸든지 한다	
	private Gamer gamerList [] = new Gamer[2]; // 게이머가 들어갈 수 있는 배열 생성
	public RockPaperScissors() { // 생성자 함수가 만들어지면 두명이 들어가게 생성
		gamerList[0] = new Gamer("철수");
		gamerList[1] = new Computer("인공지능");
	}
	public void run() { //서로 돌아가며 할 메서드 생성
		int gamerChoice, computerChoice; // 두개의 변수 생성
		while(true) {// 무한루프 - 계속 돌아가며 게임을 해야 하기 때문
			//조건 달아서 break
			gamerChoice = gamerList[0].turn(); // 생성된 변수에 입력 = 자주 사용할 것을 대비
			if(gamerChoice==4) break; // turn이 4가 되면 빠져 나가게 설정
			computerChoice = gamerList[1].turn();
			if(gamerChoice<1 || gamerChoice>4) { // 1보다 작고 또는 4보다 크면
				System.out.println("잘못 눌렀습니다.");
			} else {
				//철수[가위] vs 컴퓨터[바위]
				//컴퓨터가 이겼습니다.
				String selectGamerWord = words[gamerChoice - 1]; // 배열응 0부터 시작이고 사람은 1부터라 -1을 해줘야 한다
				String selectComputerWord = words[computerChoice - 1];//words라는 배열에서 computerChoice가 고른 것
				System.out.print(gamerList[0].getName()+"["+ selectGamerWord +"] vs ");
				System.out.println(gamerList[1].getName()+"["+ selectComputerWord +"]");
				if(gamerChoice == computerChoice) {
					System.out.println("비겼습니다.");
				} else if((gamerChoice == 1 && computerChoice == 3) ||  
						  (gamerChoice == 2 && computerChoice == 1) || 
						  (gamerChoice == 3 && computerChoice == 2) 
						) {
					System.out.println(gamerList[0].getName()+"가 이겼어요");
				} else {
					System.out.println(gamerList[0].getName()+"가 졌어요");
				}
			}
		}
	}
}
public class Chap0609 {
	public static void main(String[] args) {
		RockPaperScissors game = new RockPaperScissors();
		game.run(); // RockPaperScissors 안에 있는 run메서드 실행
	}
}





