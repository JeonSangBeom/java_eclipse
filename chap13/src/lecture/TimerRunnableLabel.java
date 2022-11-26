package lecture;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class LabelRunnableTimer implements Runnable {
	private JLabel timerLabel;
	public LabelRunnableTimer(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	@Override
	public void run() {
		int num = 0;
		while(true) {
			timerLabel.setText(Integer.toString(num));
			num++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
public class TimerRunnableLabel extends JFrame {
	TimerRunnableLabel() {
		this.setTitle("Thread ¿¬½À");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel("0");
		timerLabel.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,36));
		contentPane.add(timerLabel);
		
		LabelRunnableTimer labelTimer = new LabelRunnableTimer(timerLabel);
		Thread th = new Thread(labelTimer);
		th.start();
		
		this.setSize(300,200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new TimerRunnableLabel();
	}
}







