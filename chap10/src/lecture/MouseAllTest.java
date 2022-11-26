package lecture;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseAllTest extends JFrame{
	private JLabel label = new JLabel();	
	//Container contentPane;//접근을 위해 전역변수 생성
	public MouseAllTest() {
		this.setTitle("키보드 이벤트 연습 중입니다");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		//contentPane.addKeyListener(new MyKeyListener());
		
		//두개를 동시에 사용할때 / 하나일 경우 new MyMouseListener()로 사용하면 된다
		MyMouseListener myMouseListener = new MyMouseListener();
		contentPane.addMouseListener(myMouseListener);
		contentPane.addMouseMotionListener(myMouseListener);
		
		contentPane.setLayout(new FlowLayout());
		contentPane.add(label);
		
		this.setSize(300,300);
		this.setVisible(true);
				
	}
	// 자바는 다중 상속이 안된다 / interface는 다중은 아니고 비슷한 효과는 가능
	class MyMouseListener implements MouseListener, MouseMotionListener {// 인터페이스는 다중 상속 가능

		@Override
		public void mouseDragged(MouseEvent e) { // 마우스 누른 상태로 이동시
			label.setText("dragged("+e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {// 누르지 않고 이동시에
			label.setText("moved("+e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getClickCount());// 마우스 클릭을 연속하여 클릭 했을때 숫자 카운트가 늘어난다
			Container contentPane = (Container)e.getSource();
			if(e.getClickCount()==2) { // 더블 클릭시 마다 색 변환
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				contentPane.setBackground(new Color(r,g,b));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {// 마우스를 눌렀을때 
			label.setText("pressed("+e.getX()+","+e.getY()+")"); //pressed 및 마우스 클릭한 지점 좌표 
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {// 마우스를 누르고 땠을때
			label.setText("Released("+e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseEntered(MouseEvent e) {// 마우스 커서가 프레임 안으로 진입하는 순간
//			System.out.println(e.getSource());// getSource obj를 리턴 한다
			// 전역변수 없이 사용할땐 아래 두가지를 사용
			Container contentPane = (Container)e.getSource();
			getContentPane().setBackground(Color.YELLOW);
			//contentPane.setBackground(Color.YELLOW);  // 전역변수를 사용할때 사용하는 방법 
		}

		@Override
		public void mouseExited(MouseEvent e) {// 마우스 커서가 한번 프레임 안에 들어간 후 빠져 나올때
			//contentPane.setBackground(Color.ORANGE); 
		} 
		
	}

	public static void main(String[] args) {
		new MouseAllTest();
	}

}
