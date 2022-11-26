package lecture;
//stream -> FileReader(���ڸ� �д� ��) ���� - ���ڵ� ������ �ٲ� ���� ����
import java.io.FileReader;
import java.io.IOException;

public class Chap0801 {
	public static void main(String[] args) {
		//�����б�
		try {
			//Reader�� Writer�� ������ ���ڷ� �����ϸ� �ȴ�
			//IO�� ��κ� Exception(����)�� �߻��Ѵ� / �׷��� ������ try, catch�� �ʼ��� �Ѵ�
			FileReader fileReader = new FileReader("C:/Windows/system.ini");//(���)�Է� -> �������� ��
			int ch;
			while(true) { //while((ch = fileReader.read()) != -1) �ε� ��� ���� => -1�� �ƴ϶�� ��
				ch = fileReader.read();// read() -> intŸ�� �׷��� ���ڷ� �ҷ��´�
				if(ch==-1) break;//-1�̶�� ����� ->�ҷ��ð��� ������(�� �о��ٴ� ��)				
				System.out.print((char)ch);// int �̱� ������ char�� ����ȯ �ʿ�
			}
			fileReader.close();
		} catch (IOException e) {//���� FileNotFoundException�� ���ִ� ���� IOException���� �ٲ��ش� ����file�� ������ ���������� �߰��ϴ� ���̱� ����
			e.printStackTrace();
		}
	}
}
