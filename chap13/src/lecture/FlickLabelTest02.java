package lecture;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

class FlickLabel02 extends JLabel implements Runnable {
	// 클래스도 결국은 변수(속성)와 함수의 묶음이다 
	public long delay;
	public Color flickColor;
	public Color normalColor;
	
	
	public FlickLabel02() {		
	}
	//시작하자마자 색상 넣기
	//생성자 함수(시작하자마자 호출하겠다)
	public FlickLabel02(String txt, long delay, Color flickColor, Color normalColor) {
		//super(txt); // 부모 생성자 호출 및 글 입력
		this.setText(txt);// 자기 자신한테 바로 써도 가능은 하다
		this.delay = delay;
		this.setOpaque(true); // 불투명 처리 (색을 넣기 위해)
		this.flickColor = flickColor;
		this.normalColor= normalColor;
		thStart();
	}
	//따로 메서드로 만들어 사용 가능(시작 메서드)
	public void thStart() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		boolean isFlick= false;		
		while(true) {
			//System.out.println("aaa");
			isFlick  = !isFlick;
			if(isFlick) this.setBackground(flickColor);
			else this.setBackground(normalColor);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class FlickLabelTest02 extends JFrame {
	public FlickLabelTest02() {
		this.setTitle("Thread 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		FlickLabel02 label01 = new FlickLabel02("I LOVE JAVA", 100, Color.RED, Color.BLACK);
		JLabel label02 = new JLabel(" VS ");
		FlickLabel02 label03 = new FlickLabel02();
		
		
		contentPane.add(label01);
		contentPane.add(label02);
		contentPane.add(label03);
		//label01.thStart();
		//label03.thStart();//메서드 만들어 뒀을시 사용
		
		//매개변수 없이 사용할 경우 접근지정자는 public로 사용하여야 한다
		//label01.setText("I LOVE JAVA");
		//label01.delay=100;
		//label01.flickColor= Color.RED;
		//label01.normalColor= Color.BLACK;
		//label01.setOpaque(true);
		//label01.thStart();
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlickLabelTest02();
	}
}
