package lecture;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


//보통 Buffer를 달아서 사용한다 하나씩 하면 느려지기 때문 - 고속으로 파일 읽기 쓰기 위해
//Buffer - 용량 지정 가능  /스트링 리더 라이트 다 쓸수 있다
public class FileInputSteamTest {
	public static void main(String[] args) {
		//test.out -> FileOutputStream에서 써둔 것을 읽기
		byte b[] = new byte[6];
		try {
			FileInputStream fileInput = new FileInputStream("C:/Windows/Temp/test.out");
			int count= 0;
			int ch=0;
			while(true) {
				ch = fileInput.read();//읽어오기
				if(ch==-1) break;//ch가 -1을 만나면 멈추기
				b[count]= (byte)ch;//byte로 ch를 바꿔서 count의 변수에 담기
				count++;
			}
			for(int i=0;i<b.length;i++) System.out.print(b[i]+",");//7,51,3,4,-1,24, 출력 
			
			fileInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
