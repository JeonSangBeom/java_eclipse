package practice;
//0801���� �Է��Ѱ� �ҷ� ����
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Chap0802 {
	public static void main(String[] args) {
		FileReader fileReader = null; // ���� ���� �б�
		File phone = new File("C:/Windows/Temp/phone.txt");// ��� ����
		try {
			fileReader = new FileReader(phone);
			int ch;// �ѱ��ھ� ������
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
