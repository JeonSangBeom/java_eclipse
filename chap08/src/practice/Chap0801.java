package practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Chap0801 {
	public static void main(String[] args) {
		FileWriter fileWriter = null; // 쓰기
		File phone = new File("C:/Windows/Temp/phone.txt");// 경로 추적
		try {
			fileWriter = new FileWriter(phone); // 이곳에 저장하기
			Scanner scanner = new Scanner(System.in);
			System.out.println("전화번호를 입력하시면 phone.txt에 저장 됩니다.");
			while(true) {
				System.out.println("이름 전화번호 ex) 장성호 == 010-1111-1111");
				String line = scanner.nextLine();
				if(line.equals("그만"))break;
				fileWriter.write(line+="\r\n");//엔터 역할
			}
			scanner.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
