package lecture;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderTest extends JFrame {
	private JSlider sliderList[] = new JSlider[3];
	private JLabel colorLabel = new JLabel("SLIDER CHANGE BG");

	public JSliderTest() {
		this.setTitle("JSliderTest");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		//슬라이더 세개 설치
		for (int i = 0; i < sliderList.length; i++) {
			sliderList[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128); //수평,수직 / 최소, 최대, 지정된 값
			//수치 보이게 하려면 기본적으로 설치해야하는 것들
			sliderList[i].setPaintLabels(true);
			sliderList[i].setPaintTicks(true);
			sliderList[i].setMajorTickSpacing(50);// 큰단위 50
			sliderList[i].setMinorTickSpacing(10);// 작은 단위 10
			contentPane.add(sliderList[i]);
			// 이벤트 달기  addChangeListener - 슬라이더 
			sliderList[i].addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					//System.out.println(slider.getValue()); // 값 얻어오기
					//JSlider slider = (JSlider)e.getSource(); // 내가 걸고 있는 이벤트를 알고 싶을때 사용
					int r = sliderList[0].getValue(); //getValue = JSlider에만 있는 것
					int g = sliderList[1].getValue();
					int b = sliderList[2].getValue();
					colorLabel.setBackground(new Color(r, g, b));
				}
			});
		}
		contentPane.add(colorLabel);
		colorLabel.setOpaque(true);
		colorLabel.setBackground(new Color(128, 128, 128));
		colorLabel.setForeground(Color.WHITE);

		this.setSize(280, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new JSliderTest();
	}
}
