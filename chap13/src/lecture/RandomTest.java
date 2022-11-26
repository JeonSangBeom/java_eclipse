package lecture;
//랜덤으로 글이 나오다가 클릭하면 멈추기
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

class RandomTxt extends Thread {
	private boolean isStop= false; //상태 - state
	private Container container; // 임폴트해주기 
	
	//Container 이용
	public RandomTxt(Container container) {
		this.container = container;
	}
	
	public void finish() {
		isStop = true;
	}
	
	public void run() {
		while(true) {
			//레이블 생성
			int x = (int)(Math.random()*container.getWidth());
			int y = (int)(Math.random()*container.getHeight());			
			JLabel label = new JLabel("RANDOM");
			label.setSize(80,20);
			label.setLocation(x,y);
			container.add(label);
			//interrupt(); //예외가 호출 되는 것
			container.repaint();//반복해서 생기게 하기 위해
			try {
				Thread.sleep(100);
				if(isStop) { // 참이 나올경우
					container.removeAll();// 내용 전부 사라지기
					label = new JLabel("FINISH");
					label.setSize(80,20);
					label.setLocation(100,100);
					container.add(label);
					container.repaint();// 새로 repaint를 해줘야 다 사라진다
					return; 
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}

public class RandomTest extends JFrame {
	private RandomTxt randomTxt;
	public RandomTest() {
		this.setTitle("Thread 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
		randomTxt = new RandomTxt(contentPane);
		randomTxt.start();
		
		contentPane.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				randomTxt.finish(); // true 메서드 실행
			}
		});
		
		this.setSize(300,200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new RandomTest();
	}
}
