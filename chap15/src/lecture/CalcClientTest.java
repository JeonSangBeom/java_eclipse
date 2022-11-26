package lecture;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
//클라이언트에서 수식을 던지면 계산 해주는 서버
public class CalcClientTest {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader input = null;
		BufferedWriter output = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket("localhost",9999);//내가 열 소켓
			input = new BufferedReader(   new InputStreamReader( socket.getInputStream() ) );
			output = new BufferedWriter(  new OutputStreamWriter( socket.getOutputStream() ) );
			while(true) {
				System.out.println("계산식 입력하면 서버가 계산 결과를 알려 줍니다. ex) 10 + 10");
				//내보내기
				String ouputMsg = scanner.nextLine();
				output.write(ouputMsg+"\r\n");
				output.flush();
				//받기
				String inputMsg = input.readLine();
				System.out.println("서버가 넘겨준 "+ouputMsg+"의 계산 결과는 "+ inputMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
