package practice;

import java.util.Calendar;

public class Chap0605 {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();// calendar�� new ��� �̷��� ����(�ҷ�����)
		int hour = now.get(Calendar.HOUR_OF_DAY); // 0~23�ñ��� ������
		if(hour>4 && hour<12) System.out.println("�� ���");
		else if(hour>=12 && hour<18) System.out.println("�� �����ʹ�");
		else if(hour>=18 && hour<22) System.out.println("�� �̺��");
		else System.out.println("�� ����");
	}
}
