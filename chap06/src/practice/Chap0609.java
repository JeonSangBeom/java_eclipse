package practice;

import java.util.Scanner;
//��� vs ��ǻ�� �ΰ��� ����
//����� ������������ Ű���� ������ ����
//��ǻ�ʹ� random()
class Gamer {
	private String name;//ö�� �Ǵ� ��ǻ�Ͷ�� �̸��� ������ �ϴϱ�  ����
	private Scanner scanner = new Scanner(System.in); // �̸��� �Է��� �޾ƾ� �ϴϱ� ��ĳ�� ����
	public Gamer(String name) { // ������ �Լ��� �̸��� �޾ƿ���
		this.name = name;
	}
	public String getName() { // ������ �Լ��� ������� ���� ���� �ٲ� �� ������ ��� �ü��� �ְ� get����
		return name;
	}
	public int turn() { // ���������� �ϸ��� ������ �Ͽ����ϰ� ������ ���� ������ int���
		System.out.println(name+"[���� : 1, ���� : 2, �� : 3] >> ");
		int result = scanner.nextInt(); // �Է��� ���� �ٷ� ���Ͻ����ش� (�׷��� result ������ �� ���� ��Ƶд�)
		return result;
	}
}
class Computer extends Gamer { // ��ǻ�� �� ���̸��� ������ ��� ���� ��
	public Computer(String name) {
		super(name);//���۴� ���̸Ӹ� ����Ų�� ���ۿ��� ������ ��� �޾� �����´�
	}
	@Override
	public int turn() {
		int result = (int)(Math.random()*3)+1; // int�� Ÿ�� ĳ������ ���༭ ������ �ٲ��ش� �ڿ� +1�� 0���� �����̱� ����
												//int�� Math.floor(floor�� ����Ÿ���� double�̱� ������ �̰Ͱ� ���� �ʴ�)�� ���� ����(�Ҽ����� ���� �����ش�)
		return result;
	}
}
class RockPaperScissors {
	private String words[] = {"����","����","��"}; // ������ �ǵ��� private ���߿� get the set�� �Ͽ� �ٲٵ��� �Ѵ�	
	private Gamer gamerList [] = new Gamer[2]; // ���̸Ӱ� �� �� �ִ� �迭 ����
	public RockPaperScissors() { // ������ �Լ��� ��������� �θ��� ���� ����
		gamerList[0] = new Gamer("ö��");
		gamerList[1] = new Computer("�ΰ�����");
	}
	public void run() { //���� ���ư��� �� �޼��� ����
		int gamerChoice, computerChoice; // �ΰ��� ���� ����
		while(true) {// ���ѷ��� - ��� ���ư��� ������ �ؾ� �ϱ� ����
			//���� �޾Ƽ� break
			gamerChoice = gamerList[0].turn(); // ������ ������ �Է� = ���� ����� ���� ���
			if(gamerChoice==4) break; // turn�� 4�� �Ǹ� ���� ������ ����
			computerChoice = gamerList[1].turn();
			if(gamerChoice<1 || gamerChoice>4) { // 1���� �۰� �Ǵ� 4���� ũ��
				System.out.println("�߸� �������ϴ�.");
			} else {
				//ö��[����] vs ��ǻ��[����]
				//��ǻ�Ͱ� �̰���ϴ�.
				String selectGamerWord = words[gamerChoice - 1]; // �迭�� 0���� �����̰� ����� 1���Ͷ� -1�� ����� �Ѵ�
				String selectComputerWord = words[computerChoice - 1];//words��� �迭���� computerChoice�� �� ��
				System.out.print(gamerList[0].getName()+"["+ selectGamerWord +"] vs ");
				System.out.println(gamerList[1].getName()+"["+ selectComputerWord +"]");
				if(gamerChoice == computerChoice) {
					System.out.println("�����ϴ�.");
				} else if((gamerChoice == 1 && computerChoice == 3) ||  
						  (gamerChoice == 2 && computerChoice == 1) || 
						  (gamerChoice == 3 && computerChoice == 2) 
						) {
					System.out.println(gamerList[0].getName()+"�� �̰���");
				} else {
					System.out.println(gamerList[0].getName()+"�� �����");
				}
			}
		}
	}
}
public class Chap0609 {
	public static void main(String[] args) {
		RockPaperScissors game = new RockPaperScissors();
		game.run(); // RockPaperScissors �ȿ� �ִ� run�޼��� ����
	}
}





