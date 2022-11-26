package lecture;
//while return  / label 이용
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//다른 클래스와 충돌 때문에 02를 붙여 사용
class TimerRunnableLabel02 implements Runnable {
	private JLabel label;
	TimerRunnableLabel02(JLabel label) {
		this.label = label;
	}
	@Override
	public void run() {
		int num =  0;
		while(true) {
			label.setText(Integer.toString(num)); //문자 변경하여 넣어주기
			num++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				// 작동을 안하면 에러 메시지가 뜬다 return을 꼭 입력
				System.out.println("멈춤");
				return;
			}
		}
	}
}

public class TimerRunnableLabelTest extends JFrame {
	private Thread th;
	public TimerRunnableLabelTest() {
		this.setTitle("Thread 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel label = new JLabel();
		label.setFont(new Font("맑은 고딕",Font.BOLD,48));
		TimerRunnableLabel02 runnable = new TimerRunnableLabel02(label);
		th = new Thread(runnable);
		
		JButton btn = new JButton("STOP");
		contentPane.add(label);
		contentPane.add(btn);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btn.setEnabled(false);//버튼 동작도 못하게 하기
				th.interrupt();// 멈추게 하기
			}
		});
		
		th.start();
		
		this.setSize(300,200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new TimerRunnableLabelTest();
	}
}
