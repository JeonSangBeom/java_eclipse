package lecture;

import java.util.Scanner;

public class Break {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);//ScannerŸ���� new�� ������ ��
//		String txt = scanner.next();//next�� ���⸦ �ν� ���� �̾��� ���ڸ� �ν�
//Scanner(Ÿ��) scanner(����) = new Scanner(System.in);
		while(true) {//true ���� ���� �ݺ�
			System.out.println(">>");
		String txt = scanner.nextLine();//������ �Է� �޴� �� next�� �ν��� ���Ѵ�(���� ��)
		if(txt.equals("exit")) break; //exit �Է½� ���������� �ȴ�
		}
		System.out.println("�����մϴ�");
		scanner.close();
//		int num = 10;
//		String txt = "�强ȣ"; // String�� �⺻ �ڷ����� �ƴϱ⿡ ���� �޼ҵ尡 �����Ѵ�
		//�⺻ �ڷ����� new�� �����ϰ� ����Ͽ��� �ϳ� String��ŭ�� ���ܰ� �ȴ�
//		if(txt.equals("�强ȣ"))//equals -���ڸ� ���Ҷ� ��� 
//	}
	}
}
