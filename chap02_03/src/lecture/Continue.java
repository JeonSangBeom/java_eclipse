package lecture;

import java.util.Scanner;

public class Continue {

	public static void main(String[] args) {
		//���� �ټ����� �Է¹޾Ƽ� ���ϴ� �� ���ϱ�
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �ټ����� �Է� �Ͻø� ����� �ո� ���� ���ص帳�ϴ� ");
		int sum = 0;
		for(int i=0;i<5;i++) {
			int num = scanner.nextInt();
			if(num<=0) continue;//������ �����ϸ� continue �� �ǳʶپ��ش� / break�� �ݺ��� ���� ����������
			sum+=num;
		}
		System.out.println(sum);
		//continue���� ex) 10 20 -30 -20 10 ���� = 40
		
	}

}
