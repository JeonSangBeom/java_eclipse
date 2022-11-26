package lecture;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//모아두고 한꺼번에 보여주는 역할을 한다
public class BufferedTest {
	public static void main(String[] args) {
		FileReader fileReader = null;// file 읽어오기
		int ch;
		try {
			fileReader = new FileReader("C:/Windows/Temp/test02.txt"); //12345678 읽어오기
			BufferedOutputStream bufOut = new BufferedOutputStream(System.out,5); //버퍼량 5개씩 내보내겠다(채워져야지만 내보내진다 3을 입력시 123456 출력)
			while(true) {
				ch = fileReader.read(); // 읽어오기 그리고ch에 담기
				if(ch==-1) break;
				bufOut.write(ch);// ch에 버퍼 아웃이 쓰겠다 아래 flush가 없으면 5개만 읽힌다 - 12345 출력
			}
			bufOut.flush();// flush() - 밀어 넣어라 / 강제로 내보내는 것 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



