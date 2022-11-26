package lecture;
//FileOutputStream �� FileInputStream�� ����  - ���߿� �̹����� �����Ҷ� �ַ� �̰��� ����Ѵ�(���ڰ� �ƴ� �͵�)
// ���⼭ ����Ʈ ������ �迭�� test.out�� �᳻������ FileInputStream���� �ҷ��� �д� ���
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//OS�� ������ �� �ִ� ���α׷��� ���� �����ϴ� - �ڹٽ�ũ��Ʈ�� �Ұ��� �ϳ� �Ʒ��ѱ� ���� ���� test.hwp���� ������� �������� �����ϴ�
public class FileOutputStreamTest {
	public static void main(String[] args) {
		byte b[] = {7,51,3,4,-1,24}; // byte ������ �迭
		try {
			FileOutputStream fileOutStream = new FileOutputStream("C:/Windows/Temp/test.out");
			for(int i=0;i<b.length;i++) {
				fileOutStream.write(b[i]);//byte�������� �Ẹ��� ��
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("�����Ͽ����ϴ�");
	}
}
