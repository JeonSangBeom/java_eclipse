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
	public boolean turn() {//turn�� �ϸ� ������ ������ ������ ������ �̱�� �ͤ��� �������� ����
		System.out.println("["+name+"] : <Enter>");
		scanner.nextLine();//nextLine - enter ������ �������� �Ѿ�� �ϴ� ���
		int nums[] = new int[3];
		for(int i=0;i<3;i++) {
			nums[i] = (int)(Math.random()*3+1); // 0�̻� 3�̸��� ���� ���� �̱�� +1 �� int�� �Ǻ�ȭ�� ���־�� �Ѵ�
		}
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+"   "); // ���� ���� ���� �ϳ��� ��� (�ϳ��� ��� �� "   "���� ����)
		}
		boolean result = true; // �켱 true�� ����
		for(int i=1;i<nums.length;i++) {// i=0�� ������ ���� ���̱� ������ 1�� ���־ ����� ����(�ݺ����� �ϳ��� ���̱� ���� �̷��� ���
			if(nums[0]!=nums[i]) { // ù��°�� ������ �� �ϴ� ��� �ϳ��� �ٸ��� false �ֱ�
				result = false;
				break;
			}
		}
		return result;
	}
}

class SameNumerGame { // ���� ����
//	private Player playerList[] = new Player[3];
//	private Scanner scanner = new Scanner(System.in);
//	public SameNumerGame() { // ������ �Լ� ���� ���� ���� ������ �Ǵ� ��
//		System.out.println("������ ������ �Է��ϼ���");
//		for(int i=0;i<playerList.length;i++) {
//			playerList[i] = new Player(scanner.nextLine());
//		}
//	}
	//���ڸ� ������ �ʰ� ����ڰ� ���ϴ� ��
	private Player playerList[]; 
	private Scanner scanner = new Scanner(System.in);
	public SameNumerGame() { // ������ �Լ� ���� ���� ���� ������ �Ǵ� ��
		System.out.println("���ӿ� ������ ������ ���� �Է��ϼ���");
		int total = scanner.nextInt();
		scanner.nextLine(); //�̰� ������ ������ �ٹٲ��� ������ �ʾƼ� �ٷ� ��ĭ �پ� �ݺ������� �Ѿ ������ �߻��Ѵ�
		playerList = new Player[total];
//		System.out.println(playerList.length);
		for(int i=0;i<playerList.length;i++) {
			System.out.print(i+1 +"��° ���� �̸� �Է� >>");
			playerList[i] = new Player(scanner.nextLine());
		}
	}
	public void run() { // ���ư��� �޼��� ����
		int i=0;// ���������� ������ �Ͽ��� �ϱ� ������ �̸� ����
		while(true) {
			if(playerList[i].turn()) {
				System.out.println(playerList[i].getName()+"���� �̰���ϴ�.");
				break;
			} else {
				System.out.println(playerList[i].getName()+"���� �ƽ����ϴ�.");
				i++;// ���� ������ ����� �ؾ��ϱ� ������ i�� ���������ش�
				i=i%playerList.length;//������ ���� ���� ���ϰ� i�� ������ length�� ������ �������� 0�� �Ǿ� �ٽ� ó������ ������ �ȴ�
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




