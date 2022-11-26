package lecture;
//stream -> FileInputStream / InputStreamReader(받는 것)
//인코딩 형식에 따른 오류
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chap0802 {
	public static void main(String[] args) {
		try {
			//Stream이 붙어 있으면 바이트와 관련이 있고 / Reader이 붙어 있으면 문자와 관련이 있는 것이다
			FileInputStream fileInputStream = new FileInputStream("C:/Windows/Temp/seosi.txt"); // 바이트 단위로 읽는 것
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");//파일을 UTF-8로 읽겠다
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
