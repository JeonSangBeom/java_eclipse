package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//0.5초마다 내보내기 1~20까지
class TimerThread extends Thread {
	private BufferedWriter output;
	TimerThread(BufferedWriter output) {
		this.output = output;
	}
	public void run() {
		try {
			//내보낼 숫자 반복하여 내보내기
			for(int i=0;i<20;i++) {
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				output.write(""+i+"\r\n");
				output.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class TimerServer {
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		BufferedReader input = null;
		BufferedWriter output = null;
		try {
			listener = new ServerSocket(9999);
			socket= listener.accept();//소켓 받기
			System.out.println("연결되었습니다.");
			output = new BufferedWriter(new OutputStreamWriter(  socket.getOutputStream() ) );
			//내보내기(스레드 이용)
			TimerThread timerThread = new TimerThread(output);
			timerThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
