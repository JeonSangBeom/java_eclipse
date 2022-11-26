package practice;
//게임 10초에 가까운 사람이 이기는 게임
import java.util.Calendar;
import java.util.Scanner;

class Player { // 클래스 안에는 속성과 메서드로 존재를 해야 한다
	private Scanner scanner;
	private String name; // 변수로 빼준다(반복)
	
	public Player(String name) { // 생성자 함수 - 클래스와 이름 같게 (이름을 받아오고) / 리턴값 없음
		this.name = name;
	}
	public String getName() { // geter seter로 getname만 만들어 준다 - 한번 만들면 수정이 되지는 못하게  get만 받아온다
		return name;
		
	}
	public Scanner getScanner() {
		return scanner;
	}
	public int turn() { // 메서드 - 게임이 진행 되며 초만 끌어내면 되기 때문에 하나의 원칙 틀을 만들어 둔다 사용시 마다 불러내서 사용
		System.out.println(name + "님 게임 시작합니다. enter를 누르세요."); // 위에 지정해둔 name을 가져와 준다
		scanner = new Scanner(System.in);
		String enter = scanner.nextLine(); // nextLine() = enter를 치기 전까지 입력한 모든 값을 리턴
		Calendar now = Calendar.getInstance();// enter를 치고 나서 Calendar.getInstance 생성 후 실행(순서 중요)
		int firstSec = now.get(Calendar.SECOND); // 첫번째 sec 초를 받아오고 (현재 초)
		System.out.println("첫번째 초는 === " + firstSec); // 첫번째 초 출력
		System.out.println("10초 예상후 enter 누르세요.");
		enter = scanner.nextLine();//다시 enter 받는 것
		now = Calendar.getInstance();// 선언이 필요 없이 또 가져다 써도 된다(전에 썼던것이기 때문에) 
		int lastSec = now.get(Calendar.SECOND);
		if (lastSec < firstSec) {
			lastSec += 60; // 아니면 첫번째 초가 더 클경우 마이너스로 값이 출력이 된다
		}
		
		System.out.println("두번째 초는 === " + lastSec);
		//System.out.println(lastSec - firstSec);
		return lastSec - firstSec; //int를 리턴한 값
	}
}

class Game {
	public Game() { // 기본 생성자
		
	}
	public void run() { // run()생성자
		Player playerList[] = new Player[2]; //객체 배열 / 두개의 배열을 만들겠다
		playerList[0] = new Player("장성호");
		playerList[1] = new Player("이중화");
		
		System.out.println("10초에 가까운 사람이 이기는 게임입니다. good luck...");
		int player01Time = playerList[0].turn(); // 이 생성자로 위에 만들어둔 turn()메서드 사용 / turn의 리턴 값이 int이기 때문에 타입을 int로 잡아둔다
		int player02Time = playerList[1].turn(); 
		System.out.println(playerList[0].getName()+"님의 결과는 "+player01Time);//private 이기에 getName으로 불러와 쓸 수 있다 
		System.out.println(playerList[1].getName()+"님의 결과는 "+player02Time);
		int player01Result = Math.abs(10 - player01Time); // 10을 넘어갈 수도 있기 때문에 abs를 사용해 준다
		int player02Result = Math.abs(10 - player02Time); 
		if(player02Result == player01Result) System.out.println("승자는 없습니다. 무승부입니다.");
		else if(player02Result < player01Result) System.out.println("승자는 "+playerList[1].getName());
		else System.out.println("승자는 "+playerList[0].getName());
		playerList[0].getScanner().close();
		playerList[1].getScanner().close();//private 이기에 get으로 불러와 쓸 수 있다
	}
}
public class GuessSecond {
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}
}



