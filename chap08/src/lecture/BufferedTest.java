package lecture;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//��Ƶΰ� �Ѳ����� �����ִ� ������ �Ѵ�
public class BufferedTest {
	public static void main(String[] args) {
		FileReader fileReader = null;// file �о����
		int ch;
		try {
			fileReader = new FileReader("C:/Windows/Temp/test02.txt"); //12345678 �о����
			BufferedOutputStream bufOut = new BufferedOutputStream(System.out,5); //���۷� 5���� �������ڴ�(ä���������� ���������� 3�� �Է½� 123456 ���)
			while(true) {
				ch = fileReader.read(); // �о���� �׸���ch�� ���
				if(ch==-1) break;
				bufOut.write(ch);// ch�� ���� �ƿ��� ���ڴ� �Ʒ� flush�� ������ 5���� ������ - 12345 ���
			}
			bufOut.flush();// flush() - �о� �־�� / ������ �������� �� 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



