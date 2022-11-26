package lecture;
//소켓 사용법
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
//1.ServerTest와 ClienTest 두개의 스레드 동작(소켓을 이용하여 연결할 예정)
//
public class ServerTest {
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		BufferedReader input = null;
		BufferedWriter output = null;
		try {
			listener = new ServerSocket(9999);//포트 1~1000은 사용 금지 (총 0~6만개 이상이 있다) / 서버소켓 생성
			socket = listener.accept();//연결 시켜주기
			System.out.println("클라이언트 소켓이 연결되었습니다.");
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				//받기
				String inputMsg = input.readLine();//readLine- 한줄을 읽어라 / 받아온 글을 읽어서 변수에 담기
				if(inputMsg.equalsIgnoreCase("bye")) {//만약 받은 메시지가 bye라면(equalsIgnoreCase - 대소문자 무시하는 것)
					System.out.println("client에서 이별을 고함");
					break;
				}
				System.out.println("client가 보낸 메시지  : "+ inputMsg);
				//�뿬湲곗꽌 遺��꽣 �궡蹂대궡湲�....
				//내보내기
				System.out.println("server가 보내는 메시지 >>");
				String outputMsg = scanner.nextLine();//내가 보낼 메시지
				output.write(outputMsg+"\r\n");
				output.flush();//밀어 넣는 것
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {//무조건 실행하는 것
			scanner.close();
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
