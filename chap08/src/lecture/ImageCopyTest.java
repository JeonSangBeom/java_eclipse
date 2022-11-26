package lecture;
//다른 위치로 복사하는 법 - dog.jpg의 이미지를 바이트로 읽어서 Temp에 내보내기
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
			FileInputStream fileInput = new FileInputStream(src);// 다운로드한 file위치를 가져와서
			FileOutputStream fileOutput = new FileOutputStream(destSrc);//내가 지정한 곳으로 내보내기
			while(true) {
				ch = fileInput.read();//읽어와서
				if(ch==-1) break;
				fileOutput.write((byte)ch);//쓰기
			}
			fileOutput.close();
			fileInput.close(); // 닫을때에는 반대로 Output을 먼저 닫고 Input을 닫아야 한다
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
