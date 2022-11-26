package practice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Chap1309 extends JFrame {
	
	public Chap1309() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new GamePanel());
		this.setSize(500, 500);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Chap1309();
	}
	//안에다 쓰면 보호가 된다 클래스를 중복하여 써도 가능
	class GamePanel extends JPanel {
		private JLabel labels[] = new JLabel[3]; //숫자를 받을 것
		private JLabel resultLabel = new JLabel("마우스를 클릭하면 게임을 시작합니다."); //글자를 받을 것
		private GameThread gameTh = new GameThread(labels, resultLabel);
		public GamePanel() {
			this.setPreferredSize(new Dimension(500, 500));
			this.setLayout(null);
			
			for(int i=0;i<labels.length;i++) {
				labels[i] = new JLabel("0");//숫자
				labels[i].setFont(new Font("맑은 고딕",Font.BOLD,48));//속성 설정
				labels[i].setHorizontalAlignment(JLabel.CENTER);//정렬
				labels[i].setOpaque(true);//불투명도
				labels[i].setBackground(Color.MAGENTA);//바탕 색상
				labels[i].setForeground(Color.YELLOW);//글자 색상
				labels[i].setSize(100,70);//크기
				labels[i].setLocation((500-320)/2 + 110*i,200);//세개 구하는 식
				this.add(labels[i]);//넣어주기
			}
			//글자 레이블 추가
			resultLabel.setFont(new Font("맑은 고딕",Font.BOLD,20));
			resultLabel.setHorizontalAlignment(JLabel.CENTER);
			resultLabel.setOpaque(true);
			//resultLabel.setBackground(Color.MAGENTA);
			//resultLabel.setForeground(Color.YELLOW);
			resultLabel.setSize(500,50);
			resultLabel.setLocation(0,400);
			this.add(resultLabel);
			//게임 시작
			gameTh.start();
			//마우스 이벤트 걸기
			this.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					//System.out.println("aa");
					gameTh.gameStart();
				}
			});
		}
	}
	class GameThread extends Thread {
		private JLabel labels[];
		private JLabel resultLabel;
		private boolean isStart = false;
		GameThread(JLabel labels[], JLabel resultLabel) {
			this.labels = labels;
			this.resultLabel = resultLabel;
		}
		synchronized public void gameWait() {//synchronized 를 써줘야 오류 없이 잘 나온다
			try {
				this.wait();//대기 시키는 것
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		synchronized public void gameStart() {//멈춘 것을 깨우기
			this.notify();//대기시킨 것을 다시 일으켜주는 것
		}
		
		public void run() {
			while(true) {
				gameWait();//게임 멈추기 , 시작은 했지만 시작하자마자 멈춰 준다
				try {
					int num01 = (int)(Math.random()*10);
					int num02 = (int)(Math.random()*10);
					int num03 = (int)(Math.random()*10);
					Thread.sleep(100);
					labels[0].setText(Integer.toString(num01));//랜덤 만든걸 넣어주기
					Thread.sleep(100);
					labels[1].setText(Integer.toString(num02));
					Thread.sleep(100);
					labels[2].setText(Integer.toString(num03));
					if(num01==num02 && num02==num03) {
						resultLabel.setText("GOOD LUCK");
					} else {
						resultLabel.setText("FAIL!!! SHOW ME THE MONEY");
					}
					//return; // 이것을 통해 빠져나갈 수 있다 하지만 스레드 자체가 종료가 되기 때문에 사용하지 않는다
					//isStart=false; // 하나씩 실행 시킬떄 사용 가능 하지만 wait같은 것을 사용하였기 때문에 굳이 사용하지 않아도 된다
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}
}




