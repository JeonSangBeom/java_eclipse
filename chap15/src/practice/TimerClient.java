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
			System.out.println("������ �����Ͽ����ϴ�..");
			input = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			String inputMsg = "";//�������� ���� ����
			while(true) {
				//�ޱ�
				inputMsg = input.readLine();
				System.out.println(" "+inputMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
