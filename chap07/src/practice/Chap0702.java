package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Chap0702 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("6���� �������� ��ĭ���� �Է��Ͻÿ�. abcdef >>");		
		
		ArrayList<Character> scoreList = new ArrayList<>();//����Ÿ�� Character
		String str = scanner.next();
		
		for (int i = 0; i < 6; i++) {
			char ch = str.charAt(i); //charAt(0) 0�� ��ġ�� �ִ� ���� �̴� ��
			scoreList.add(ch);
		}
		System.out.println(scoreList.get(5));// �ҷ��ü� �ִ� ���� 6�� �ʰ��Ǹ� ��ȿ
		
		double sum = 0;//����� ���� �ϱ� ������ sum �̸� ����
		for (int i = 0; i < 6; i++) {
			char ch = scoreList.get(i);
			switch (ch) {// ch�� �޾�����
				case 'a':sum += 4.0;break; //�ҹ��� a��� sum�� 4 ���ϱ�
				case 'b':sum += 3.0;break;
				case 'c':sum += 2.0;break;
				case 'd':sum += 1.0;break;
				case 'f':sum += 0.0;break;
			}
		}
		System.out.println(sum/scoreList.size());
	}
}
