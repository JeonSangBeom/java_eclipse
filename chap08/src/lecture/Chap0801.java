package lecture;
//stream -> FileReader(문자를 읽는 것) 사용법 - 인코딩 형식을 바꿀 수는 없다
import java.io.FileReader;
import java.io.IOException;

public class Chap0801 {
	public static void main(String[] args) {
		//파일읽기
		try {
			//Reader나 Writer이 붙으면 문자로 생각하면 된다
			//IO는 대부분 Exception(예외)이 발생한다 / 그렇기 때문에 try, catch를 필수로 한다
			FileReader fileReader = new FileReader("C:/Windows/system.ini");//(경로)입력 -> 가져오는 것
			int ch;
			while(true) { //while((ch = fileReader.read()) != -1) 로도 사용 가능 => -1이 아니라면 참
				ch = fileReader.read();// read() -> int타입 그래서 숫자로 불러온다
				if(ch==-1) break;//-1이라면 멈춰라 ->불러올것이 없으면(다 읽었다는 뜻)				
				System.out.print((char)ch);// int 이기 때문에 char로 형변환 필요
			}
			fileReader.close();
		} catch (IOException e) {//기존 FileNotFoundException이 떠있는 것을 IOException으로 바꿔준다 기존file은 파일이 없을때에만 발견하는 것이기 때문
			e.printStackTrace();
		}
	}
}
