package lecture;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
//Thread는 다중 상속이 안되기 때문에 Runnable를 인터페이스 하여 사용
class FlickLabel extends JLabel implements Runnable {
	private long delay;

	//생성자 생성
	public FlickLabel(String txt, long delay) {
		super(txt); // 부모 생성자 호출 JLabel에 또 JLabel을 쓸수 없어 이렇게 사용
		this.delay = delay;
		this.setOpaque(true);//색상 넣기 위해 
		Thread thread = new Thread(this);//Thread 생성 (나 자신을 넣겠다)
		thread.start();
	}

	@Override
	public void run() {
		boolean isFlick= false;
		while(true) {
			isFlick  = !isFlick;//왔다갔다 하게 하기
			if(isFlick) this.setBackground(Color.YELLOW);
			else this.setBackground(Color.GREEN);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class FlickLabelTest extends JFrame {
	public FlickLabelTest() {
		this.setTitle("Thread 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		FlickLabel label01 = new FlickLabel("I LOVE JAVA", 100);// 레이블 스레드 생성자 사용
		JLabel label02 = new JLabel(" VS ");
		FlickLabel label03 = new FlickLabel("I HATE JAVA", 200);
		
		contentPane.add(label01);
		contentPane.add(label02);
		contentPane.add(label03);
		
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlickLabelTest();
	}
}
