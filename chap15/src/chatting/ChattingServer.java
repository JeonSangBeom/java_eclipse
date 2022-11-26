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

import chatting.ChattingClient.Receiver;

public class ChattingServer extends JFrame {
	private JTextField sender;//값을 보낼 것
	private ServerSocket listener = null;
	private Socket socket = null;
	private BufferedReader input = null;
	private BufferedWriter output = null;
	private Receiver receiver = null;
	ChattingServer() {
		this.setTitle("채팅서버");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		//보내는 것
		sender = new JTextField();
		//엔터치면 값 넘어가게 이벤트 걸기
		sender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = sender.getText();
				try {
					output.write(msg+"\r\n");//메시지 넣기
					output.flush();//밀어넣기
					receiver.append("\r\n 서버 : "+msg);
					int endPos = receiver.getText().length();
					receiver.setCaretPosition(endPos);
					sender.setText(null);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		receiver = new Receiver();
		receiver.setBackground(Color.YELLOW);
		receiver.setForeground(Color.BLACK);
		contentPane.add(sender, BorderLayout.SOUTH);
		contentPane.add(new JScrollPane(receiver), BorderLayout.CENTER);
		
		this.setSize(400,400);
		this.setVisible(true);
		//구조 설정 (setup메서드)
		try {
			setup();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread th = new Thread(receiver);
		th.start();
	}
	//너무 길어질 것 같아 서버나 받고 보낼 리스너 만들어 두기
	private void setup() throws IOException {//throws - try catch와 같은 것이다
		listener = new ServerSocket(9999);
		socket = listener.accept();
		input = new BufferedReader(   new InputStreamReader( socket.getInputStream() ) );
		output = new BufferedWriter(  new OutputStreamWriter( socket.getOutputStream() ) );
	}
	
	class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() {
			String msg = null;
			while(true) {
				try {
					msg = input.readLine();
					System.out.println(msg);
				} catch (IOException e) {
					//e.printStackTrace(); 
					System.exit(0); //이게 유효
				}
				this.append("\r\n 클라이언트 : "+msg);
				int endPos = this.getText().length();
				System.out.println(endPos);
				this.setCaretPosition(endPos);
			}
		}
	}
	
	public static void main(String[] args) {
		new ChattingServer();
	}
}




