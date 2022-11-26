package lecture;
//stream -> fileWriter(파일쓰기) 내보내기
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Chap0803 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileWriter fileWriter = null; // 파일 쓰기
		int ch;
		try {
			fileWriter = new FileWriter("C:/Windows/Temp/test.txt");
			while(true) {
				String line = scanner.nextLine();//nextLine 엔터 치는 것 (엔터치면 다음으로 넘어간다)
				if(line.length()==0) break;//공백에 엔터를 치면 멈추겠다는 뜻
				fileWriter.write(line, 0, line.length());// fileWriter.write - 입력하겠다는 것 (line을 0번 부터 엔터치기 전까지-한줄 길이만큼 쓰겠다)				
				fileWriter.write("\r\n",0,2);// "\r\n",0,2 줄바꿈하게 만드는 것
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
