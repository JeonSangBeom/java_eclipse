import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		//Scanner ����Ʈ�ؼ� ������ ������ �Է¹ޱ�..
		/*
		 * 90 �̻��̸� A
		 * 80B
		 * 70C
		 * 60d
		 * ������ ��
		 */
		
		Scanner scanner = new Scanner(System.in); //�޸� ���� - heap ������ ���Ѵ�
		//(static:�� ���� - heap:��� ���� ������� �� - stack:ȣ�� ����)
		System.out.println("������ �Է��ϼ���");
		int score = scanner.nextInt();//��ĳ�� ���� ������ ������
		String result = null;
		if(score >= 90) {
			result = "A";
		} else if(score>=80) {
			result = "B";
		}else if(score>=70) {
			result = "c";
		}else if(score>=60) {
			result = "d";
		}else {
			result  = "F";
		}
		System.out.println("����� ������ ==="+result);
		scanner.close();
	}

}
