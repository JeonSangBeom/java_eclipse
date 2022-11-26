package lecture;
//FileOutputStream 과 FileInputStream의 관계  - 나중에 이미지를 저장할때 주로 이것을 사용한다(문자가 아닌 것들)
// 여기서 바이트 형식의 배열을 test.out에 써내보내고 FileInputStream에서 불러와 읽는 방식
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//OS에 관여할 수 있는 프로그래밍 언어여야 가능하다 - 자바스크립트는 불가능 하나 아래한글 같은 것은 test.hwp같은 방식으로 내보내도 가능하다
public class FileOutputStreamTest {
	public static void main(String[] args) {
		byte b[] = {7,51,3,4,-1,24}; // byte 형식의 배열
		try {
			FileOutputStream fileOutStream = new FileOutputStream("C:/Windows/Temp/test.out");
			for(int i=0;i<b.length;i++) {
				fileOutStream.write(b[i]);//byte형식으로 써보라는 뜻
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("저장하였습니다");
	}
}
