package practice;
//0801에서 입력한거 불러 오기
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Chap0802 {
	public static void main(String[] args) {
		FileReader fileReader = null; // 파일 문자 읽기
		File phone = new File("C:/Windows/Temp/phone.txt");// 경로 추적
		try {
			fileReader = new FileReader(phone);
			int ch;// 한글자씩 읽을때
			while(true) {
				ch = fileReader.read();
				if(ch==-1) break;
				System.out.print((char)ch);
			}
			fileReader.close();
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
