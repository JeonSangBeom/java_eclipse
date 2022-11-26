package lecture;
//stream -> FileInputStream / InputStreamReader(�޴� ��)
//���ڵ� ���Ŀ� ���� ����
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chap0802 {
	public static void main(String[] args) {
		try {
			//Stream�� �پ� ������ ����Ʈ�� ������ �ְ� / Reader�� �پ� ������ ���ڿ� ������ �ִ� ���̴�
			FileInputStream fileInputStream = new FileInputStream("C:/Windows/Temp/seosi.txt"); // ����Ʈ ������ �д� ��
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");//������ UTF-8�� �аڴ�
			int ch;
			while(true) {
				ch = inputStreamReader.read();
				if(ch==-1) break;
				System.out.print((char)ch);
			}
			inputStreamReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
