package practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Chap0801 {
	public static void main(String[] args) {
		FileWriter fileWriter = null; // ����
		File phone = new File("C:/Windows/Temp/phone.txt");// ��� ����
		try {
			fileWriter = new FileWriter(phone); // �̰��� �����ϱ�
			Scanner scanner = new Scanner(System.in);
			System.out.println("��ȭ��ȣ�� �Է��Ͻø� phone.txt�� ���� �˴ϴ�.");
			while(true) {
				System.out.println("�̸� ��ȭ��ȣ ex) �强ȣ == 010-1111-1111");
				String line = scanner.nextLine();
				if(line.equals("�׸�"))break;
				fileWriter.write(line+="\r\n");//���� ����
			}
			scanner.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
