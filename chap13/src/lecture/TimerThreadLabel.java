package lecture;
//스레드 및 JFrame 함께 사용
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
//스레드 생성
class LabelTimer extends Thread {
	private JLabel timerLabel;
	//timerLabel을 받는 기본 생성자 생성
	public LabelTimer(JLabel timerLabel) {
		this.timerLabel = timerLabel; 
	}
	public void run() {
		int num = 0;
		while(true) {
			timerLabel.setText(Integer.toString(num));//num 등록
			num++;
			try {
				Thread.sleep(1000);//static이다 이렇게 쓰는게 맞지만 Thread를 상속 받았기 때문에 굳이 쓰지 않아도 상관 없다
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class TimerThreadLabel extends JFrame {
	TimerThreadLabel() {
		this.setTitle("Thread 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel("0");
		timerLabel.setFont(new Font("맑은 고딕",Font.BOLD,36));
		contentPane.add(timerLabel);
		
		//스레드 생성자 사용
		LabelTimer labelTimer = new LabelTimer(timerLabel);
		labelTimer.start();
		
		this.setSize(300,200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new TimerThreadLabel();
	}
}







