package practice;

import java.util.Scanner;

public class Chap0611 {
	public static void main(String[] args) {
		System.out.println("������ �Է��ϼ���...>>");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine(); // ��ɾ� �Է� �ޱ�
		StringBuffer sb = new StringBuffer(str);//StringBuffer ����
		// i love java
		//��� : love!hate ====> i hate java // love�� hate�� �ٲٶ�� ��
		//tokens= [love, hate] - love!hate�� ������ �ΰ��� ���� �� ��(tokens�� ����ϸ�)
		while(true) {
			System.out.println("��� : (!�� �̿��Ͽ� ���� �ٲٱ�) ");
			String command = scanner.nextLine();
			if(command.equals("�׸�")) {// �������� �Է��� �Ͱ� �׸��� ������ ���� break
				System.out.println("�����մϴ�.");
				break;
			}
			String tokens[] = command.split("!"); // !��  �ΰ��� �и��� �� tokens�� �ֱ� �迭��
			System.out.println("tokens[0] = "+tokens[0].length());
			if(tokens.length!=2) { // ������ �ΰ��� ���� 2�� �ƴ϶�� ���� �ɱ�(���� ���̴� ����� ����)
				System.out.println("�߸��� ����Դϴ�.");
			} else {
				int start = sb.indexOf(tokens[0]);//������ ���� ù��°�� �ʿ��ϱ� ������ start�� ���� ������ֱ� 
				//tokens[0](������ ����)��ġ �������� ã�� �� ��ġ�� �ε��� ���� ����
				sb.replace(start, start+tokens[0].length(), tokens[1]);//replace�� ���۰� ���� ã�� ����° ���� ������ �ٲ��
				//������ ������ ��ġ ���� start / start + tokens[0].length() - ����� ������ ���̵� ����Ͽ� �� ���� ���ο� ������ �ֱ�
				System.out.println(sb);// �׳� �Է��Ͽ��� ����
				System.out.println("start = "+start);
			}
		}
	}
}






