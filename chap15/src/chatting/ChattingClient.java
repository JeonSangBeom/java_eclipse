package chatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import chatting.ChattingServer.Receiver;
//채팅창 만들기
public class ChattingClient extends JFrame {
	private JTextField sender;//값을 보낼 것(채팅 입력하는 곳)
	private Socket socket = null;
	private BufferedReader input = null;
	private BufferedWriter output = null;
	private Receiver receiver = null;//채팅 창
	ChattingClient() {
		this.setTitle("채팅 클라이언트 서버");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		//보내는 것
		sender = new JTextField();
		sender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = sender.getText();
				try {
					output.write(msg+"\r\n");
					output.flush();
					receiver.append("\r\n 클라이언트 : "+msg);//리시버에 붙이기
					int endPos = receiver.getText().length();
					receiver.setCaretPosition(endPos);
					sender.setText(null);// 입력 후 공백 
					
				} catch (IOException e1) {
					e1.printStackTrace();
					
				}
			}
		});
		
		//리시버 선언 및 패널에 붙이기
		receiver = new Receiver();
		receiver.setBackground(Color.BLUE);
		receiver.setForeground(Color.WHITE);
		contentPane.add(sender, BorderLayout.SOUTH);
		contentPane.add(new JScrollPane(receiver), BorderLayout.CENTER);//스크롤바 생성(리시버 추가할때 함꼐 넣어주면 된다)
		
		this.setSize(400,400);
		this.setVisible(true);
		//구조 설정 (setup메서드)
		try {
			setup();
		} catch (IOException e) {
			//e.printStackTrace();
			System.exit(0);
		}
		//러너블로 받은 스레드 사용시 이렇게 매개변수 사용
		Thread th = new Thread(receiver);
		th.start();
	}
	private void setup() throws IOException {
		socket = new Socket("localhost",9999);//도메인 주소를 타인에게 알려주면 채팅이 가능//내부망
		input = new BufferedReader(   new InputStreamReader( socket.getInputStream() ) );
		output = new BufferedWriter(  new OutputStreamWriter( socket.getOutputStream() ) );
	}
	//스레드 생성
	class Receiver extends JTextArea implements Runnable {// 스레드 구현 방법 중 하나
		@Override
		public void run() {
			String msg = null;
			while(true) {
				try {
					msg = input.readLine();//한줄 읽기
				} catch (IOException e) {
					e.printStackTrace();
				}
				//읽은 것을 내 JTextArea에 갔다 붙이기
				this.append("\r\n 서버 : "+msg);
				int endPos = this.getText().length();//스크롤바가 생성되면 거기에 맞게 내려가게 (끝 위치)
				this.setCaretPosition(endPos);//커서위치
			}
		}
	}
	
	public static void main(String[] args) {
		new ChattingClient();
	}
}
