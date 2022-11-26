package lecture;
//PaintPanelTest
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintPanelTest extends JFrame {
	private MyPanel myPanel = new MyPanel(); //선언
	
	public PaintPanelTest() {
		this.setTitle("그림그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setContentPane(myPanel);//ContentPane을 직접 만든 JPanel로 바꿔치기 하는 방법 
		// 기존 JFrame이 가지고 있는 Container(Panel)늘 내가 만든 MyPanel로 바꾸겠다
		this.setSize(300,600);
		this.setVisible(true);
	}
	//클래스 JPanel생성 - 그림 그리기
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {// 그림 그리는 메서드 - paintComponent를 오버라이딩 하면 사용 가능
			//글자 그리기
			super.paintComponent(g);//부모에 있는 paintComponent(g)를 호출 하는 법 - 이럴 경우 그 전에 작업한게 전부 사라진다
			//속성 설정
			//g.setColor(new Color(0xff0000)); // 빨간색
			g.setColor(new Color(255,0,0));//색상(내가 정할때 사용하는 방벙) / Color.BLUE - 같은 경우는 기존에 있는 것 사용할때
			g.setFont(new Font("맑은 고딕",Font.BOLD,24));
			//글자 입력
			g.drawString("I LOVE JAVA",50,50);
			g.drawString("I HATE JAVA",100,100);
			
			//글자 반복문
			super.paintComponent(g);//그전 것 지워주기
			for(int i=0;i<5;i++) {
				g.setFont(new Font("맑은 고딕",Font.BOLD,i*10+10));//+10은 최소 10사이즈 때문
				g.drawString("Hello"+i, 10, 50+50*i); // 글자 그리기 (입력,좌표)
			}
			
			//선 그리기
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawLine(10, 10, 100, 100);//(좌표,선 길이)
			g.setColor(Color.BLUE);
			g.drawOval(50,50,100,100);//원그리기(좌표,원크기(두개가 동일시에만 적용된다))
			
			//랜던하게 그리기
			super.paintComponent(g);			
			for(int i=0;i<100;i++) {
				//색상
				int red = (int)(Math.random()*256);
				int green = (int)(Math.random()*256);
				int blue = (int)(Math.random()*256);
				g.setColor(new Color(red,green,blue,255/2));//255/2(255는 완전투명,/2는 반만 투명) - 투명도 주기 위해(alpha위치)
				//좌표
				int posX = (int)(Math.random()*100)+50;//50~150
				int posY = (int)(Math.random()*400)+50;
				int radius = (int)(Math.random()*50+50);// 크기 다른 원을 위해
				g.drawOval(posX,posY,radius,radius);// 라인 그리기
				g.fillOval(posX,posY,radius,radius);//색 채우기
			}
			
			//원 그리기
//			super.paintComponent(g);
//			g.drawArc(50,100,100,100,90,90);//(좌표,넓이,시작90도 기준으로,90도까지 그리기(360도를 그려야 원이 그려진다)
			
//			//다각형 그리기
//			super.paintComponent(g);
//			//150,0,0,300,150,600,300,300,
//			int polyX[] = {150,0,150,300};//x좌표 150,0,150,300 이동 하여 그리기(다이아몬드)
//			int polyY[] = {0,300,600,300};//반대로 y좌표
//			g.setColor(new Color(255,0,0));
//			g.fillPolygon(polyX, polyY, 4);//색을 채우고 싶을 때(좌표,선갯수)
//			g.setColor(Color.BLUE);
//			g.drawPolygon(polyX,polyY,4);// 배열을 받아 그려야 한다(좌표,선갯수)
		}
	}
	
	public static void main(String[] args) {
		new PaintPanelTest();
	}

}
