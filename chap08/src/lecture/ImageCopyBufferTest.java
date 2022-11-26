package lecture;
// 버퍼를 이용한 이미지 복사하기
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopyBufferTest {
	public static void main(String[] args) {
		File src = new File("C:/Users/jsb43/Downloads/cat.jpg");
		File destSrc = new File("C:/Windows/Temp/copyCat.jpg");
		int ch;
		try {
			FileInputStream fileInput = new FileInputStream(src);
			FileOutputStream fileOutput = new FileOutputStream(destSrc);			
			byte buffer[] =  new byte[1024*10];// 10kbyte씩 내보내는 것
			//버퍼로 읽기
			while(true) {
				ch = fileInput.read(buffer); // 읽을때 버퍼만큼 읽어라
				fileOutput.write(buffer,0,ch);// 버퍼만큼 나가는데 0부터 ch까지 읽어서 나가라(써보내기)
				if(ch<buffer.length) break;//ch가 버퍼길이보다 작다면 멈추기
			}
			//일반적으로 읽는 방법 / 하나씩 읽어서 내보내기 때문에 시간이 더 올래 걸린다
//			while(true) {
//				ch = fileInput.read();
//				if(ch==-1) break;
//				fileOutput.write((byte)ch);
//			}
			fileOutput.close();
			fileInput.close();
			System.out.println(src.getPath()+"를"+destSrc.getPath()+"로 복사하였습니다.");
//			C:\Users\jsb43\Downloads\cat.jpg를C:\Windows\Temp\copyCat.jpg로 복사하였습니다. - 출력
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
