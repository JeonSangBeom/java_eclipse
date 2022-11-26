package lecture;
//stream -> fileWriter(���Ͼ���) ��������
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Chap0803 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileWriter fileWriter = null; // ���� ����
		int ch;
		try {
			fileWriter = new FileWriter("C:/Windows/Temp/test.txt");
			while(true) {
				String line = scanner.nextLine();//nextLine ���� ġ�� �� (����ġ�� �������� �Ѿ��)
				if(line.length()==0) break;//���鿡 ���͸� ġ�� ���߰ڴٴ� ��
				fileWriter.write(line, 0, line.length());// fileWriter.write - �Է��ϰڴٴ� �� (line�� 0�� ���� ����ġ�� ������-���� ���̸�ŭ ���ڴ�)				
				fileWriter.write("\r\n",0,2);// "\r\n",0,2 �ٹٲ��ϰ� ����� ��
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
