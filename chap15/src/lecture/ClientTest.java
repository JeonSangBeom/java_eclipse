package lecture;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		BufferedReader input = null;//텍스트 보낼때
		BufferedWriter output = null;//받을때
		try {
			socket = new Socket("localhost",9999);//127.0.0.1 = localhost - 기본 ip  / 서버 뚫어둔 곳(ServerTest)에 연결
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//InputStreamReader(소켓에서 받은 글자를 한글자씩 받아오겠다) BufferedReader 그것을 모아서 보내기
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				System.out.println("client에서 보낸메시지 : >> ");
				String outputMsg = scanner.nextLine();//보내는 메시지는 입력하여 보내게 하기 위해
				if(outputMsg.equalsIgnoreCase("bye")) {//만약 받은 메시지가 bye라면(equalsIgnoreCase - 대소문자 무시하는 것)
					output.write(outputMsg+"\r\n");//입력한 메시지를 output으로 써보내겠다
					output.flush(); //버퍼는 차야지만 넘어가지만 flush는 용량이 차지 않아도 넘기는 것
					break;
				}
				output.write(outputMsg+"\r\n");
				output.flush();
				String inputMsg = input.readLine();//한줄 읽어오기
				System.out.println("서버가 보내온 메시지 :  "+inputMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
