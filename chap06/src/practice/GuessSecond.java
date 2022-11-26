package practice;
//���� 10�ʿ� ����� ����� �̱�� ����
import java.util.Calendar;
import java.util.Scanner;

class Player { // Ŭ���� �ȿ��� �Ӽ��� �޼���� ���縦 �ؾ� �Ѵ�
	private Scanner scanner;
	private String name; // ������ ���ش�(�ݺ�)
	
	public Player(String name) { // ������ �Լ� - Ŭ������ �̸� ���� (�̸��� �޾ƿ���) / ���ϰ� ����
		this.name = name;
	}
	public String getName() { // geter seter�� getname�� ����� �ش� - �ѹ� ����� ������ ������ ���ϰ�  get�� �޾ƿ´�
		return name;
		
	}
	public Scanner getScanner() {
		return scanner;
	}
	public int turn() { // �޼��� - ������ ���� �Ǹ� �ʸ� ����� �Ǳ� ������ �ϳ��� ��Ģ Ʋ�� ����� �д� ���� ���� �ҷ����� ���
		System.out.println(name + "�� ���� �����մϴ�. enter�� ��������."); // ���� �����ص� name�� ������ �ش�
		scanner = new Scanner(System.in);
		String enter = scanner.nextLine(); // nextLine() = enter�� ġ�� ������ �Է��� ��� ���� ����
		Calendar now = Calendar.getInstance();// enter�� ġ�� ���� Calendar.getInstance ���� �� ����(���� �߿�)
		int firstSec = now.get(Calendar.SECOND); // ù��° sec �ʸ� �޾ƿ��� (���� ��)
		System.out.println("ù��° �ʴ� === " + firstSec); // ù��° �� ���
		System.out.println("10�� ������ enter ��������.");
		enter = scanner.nextLine();//�ٽ� enter �޴� ��
		now = Calendar.getInstance();// ������ �ʿ� ���� �� ������ �ᵵ �ȴ�(���� ������̱� ������) 
		int lastSec = now.get(Calendar.SECOND);
		if (lastSec < firstSec) {
			lastSec += 60; // �ƴϸ� ù��° �ʰ� �� Ŭ��� ���̳ʽ��� ���� ����� �ȴ�
		}
		
		System.out.println("�ι�° �ʴ� === " + lastSec);
		//System.out.println(lastSec - firstSec);
		return lastSec - firstSec; //int�� ������ ��
	}
}

class Game {
	public Game() { // �⺻ ������
		
	}
	public void run() { // run()������
		Player playerList[] = new Player[2]; //��ü �迭 / �ΰ��� �迭�� ����ڴ�
		playerList[0] = new Player("�强ȣ");
		playerList[1] = new Player("����ȭ");
		
		System.out.println("10�ʿ� ����� ����� �̱�� �����Դϴ�. good luck...");
		int player01Time = playerList[0].turn(); // �� �����ڷ� ���� ������ turn()�޼��� ��� / turn�� ���� ���� int�̱� ������ Ÿ���� int�� ��Ƶд�
		int player02Time = playerList[1].turn(); 
		System.out.println(playerList[0].getName()+"���� ����� "+player01Time);//private �̱⿡ getName���� �ҷ��� �� �� �ִ� 
		System.out.println(playerList[1].getName()+"���� ����� "+player02Time);
		int player01Result = Math.abs(10 - player01Time); // 10�� �Ѿ ���� �ֱ� ������ abs�� ����� �ش�
		int player02Result = Math.abs(10 - player02Time); 
		if(player02Result == player01Result) System.out.println("���ڴ� �����ϴ�. ���º��Դϴ�.");
		else if(player02Result < player01Result) System.out.println("���ڴ� "+playerList[1].getName());
		else System.out.println("���ڴ� "+playerList[0].getName());
		playerList[0].getScanner().close();
		playerList[1].getScanner().close();//private �̱⿡ get���� �ҷ��� �� �� �ִ�
	}
}
public class GuessSecond {
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}
}



