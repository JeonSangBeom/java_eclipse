package lecture;
//�ٸ� ��ġ�� �����ϴ� �� - dog.jpg�� �̹����� ����Ʈ�� �о Temp�� ��������
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopyTest {
	public static void main(String[] args) {
		File src = new File("C:/Users/jsb43/Downloads/dog.jpg");
		File destSrc = new File("C:/Windows/Temp/copyDog.jpg");
		int ch;
		try {
			FileInputStream fileInput = new FileInputStream(src);// �ٿ�ε��� file��ġ�� �����ͼ�
			FileOutputStream fileOutput = new FileOutputStream(destSrc);//���� ������ ������ ��������
			while(true) {
				ch = fileInput.read();//�о�ͼ�
				if(ch==-1) break;
				fileOutput.write((byte)ch);//����
			}
			fileOutput.close();
			fileInput.close(); // ���������� �ݴ�� Output�� ���� �ݰ� Input�� �ݾƾ� �Ѵ�
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
