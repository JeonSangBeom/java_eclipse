package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chap1211 extends JFrame {
	//private InputPanel inputPanel = new InputPanel();
	private ChartPanel chartPanel = new ChartPanel();
	private String labels[] = {"apple","cherry","berry","prune"};
	private JTextField tfList[] = new JTextField [4];
	private int arcList[] = new int[4];
	private int dataList[] = {0,0,0,0};//데이터 담아둘 곳
	private Color colors[] = {Color.RED,Color.BLUE,Color.MAGENTA,Color.ORANGE};
	
	public Chap1211() {
		this.setTitle("파이차트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		//선언및 추가 방법 - 다르게 하면 오류 발생
		contentPane.add(new InputPanel(),BorderLayout.NORTH);
		contentPane.add(chartPanel,BorderLayout.CENTER);
		
		this.setSize(500,400);
		this.setVisible(true);
	}
	
	private class InputPanel extends JPanel {
		public InputPanel() {
			this.setBackground(Color.LIGHT_GRAY);
			this.setLayout(new FlowLayout());
			for(int i=0;i<4;i++) {
				tfList[i] = new JTextField("0",5);//0이 들어가고 글자수 5개가 들어가겠다
				tfList[i].addActionListener(new MyActionListener());
				this.add(new JLabel(labels[i]));//레이블 생성 및 추가
				this.add(tfList[i]);
			}
		}
		class MyActionListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();// 정보가져오기
				int num = Integer.parseInt(tf.getText());// 텍스트필드에 입력한 값 num변수에 넣어두기
				int sum = 0;//입력한 4개의 합 구하기
				for(int i=0;i<4;i++) {
					dataList[i] =  Integer.parseInt(tfList[i].getText());//tf.getText()로 사용하여도 된다
					//tfList에 들어가 있는 입력 값 가져와서 배열에 넣기
					sum+=dataList[i];//순서대로 전부 더해주기
				}
				//0부터 시작해서 360도로 4등분 필요
				for(int i=0;i<4;i++) {
					//System.out.println((double)dataList[i] / (double)sum);
					arcList[i] = (int)(Math.round( (double)dataList[i] / (double)sum * 360));
					//360도로 4등분 -sum과 dataList 둘다 int여서 형변환 필요
					//System.out.print(arcList[i]+",");
				}
				chartPanel.repaint();//엔터 칠때마다 끝내지 않고 새로 그리게 해주기
			}
		}
	}
	
	private class ChartPanel extends JPanel {
		//그림 그리기
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int startAngle = 0;//0부터 시작해서 360도로
			for(int i=0;i<4;i++) {
				g.setColor(colors[i]);//만들어둔 배열 사용
				g.fillArc(150, 50, 200, 200, startAngle, arcList[i]);//(그릴위치,넓이,높이,시작지점(각도),끝지점(각도))
				startAngle+=arcList[i];
			}
			//원이 4등분 된다
//			g.setColor(Color.RED);
//			g.fillArc(150, 50, 200, 200, 0, 90);
//			g.setColor(Color.GREEN);
//			g.fillArc(150, 50, 200, 200, 90, 90);
//			g.setColor(Color.BLUE);
//			g.fillArc(150, 50, 200, 200, 180, 90);
//			g.setColor(Color.ORANGE);
//			g.fillArc(150, 50, 200, 200, 270, 90);
		}
	}
	
	public static void main(String[] args) {
		new Chap1211();
	}
}
