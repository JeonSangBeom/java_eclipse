package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//0.5�ʸ��� �������� 1~20����
class TimerThread extends Thread {
	private BufferedWriter output;
	TimerThread(BufferedWriter output) {
		this.output = output;
	}
	public void run() {
		try {
			//������ ���� �ݺ��Ͽ� ��������
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
			socket= listener.accept();//���� �ޱ�
			System.out.println("����Ǿ����ϴ�.");
			output = new BufferedWriter(new OutputStreamWriter(  socket.getOutputStream() ) );
			//��������(������ �̿�)
			TimerThread timerThread = new TimerThread(output);
			timerThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
