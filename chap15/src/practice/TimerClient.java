package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimerClient {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader input = null;
		BufferedWriter output = null;
		try {
			socket = new Socket("localhost",9999);
			System.out.println("서버에 접속하였습니다..");
			input = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			String inputMsg = "";//공백으로 변수 생성
			while(true) {
				//받기
				inputMsg = input.readLine();
				System.out.println(" "+inputMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
