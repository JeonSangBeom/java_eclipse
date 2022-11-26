package lecture;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ToolTipManager;

public class ToolBarTest extends JFrame {
	private Container contentPane;
	ToolBarTest() {
		this.setTitle("툴바 만들기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		createToolbar();

		this.setSize(300, 300);
		this.setVisible(true);
	}
	private void createToolbar() {
		JToolBar toolBar = new JToolBar("toolbar");//툴바 생성 및 선언
		toolBar.setBackground(Color.LIGHT_GRAY);//색상
		JButton btnNew = new JButton("new");//버튼 생성
		btnNew.setToolTipText("create new file");//커서 접근시 설명란(툴팁)
		toolBar.add(btnNew);
		
		toolBar.addSeparator();//구분(선 생성)
		JButton btnOpen = new JButton(new ImageIcon("images/frame.png"));//이미지 사용(버튼생성)
		btnOpen.setToolTipText("open file");
		toolBar.add(btnOpen);
		
		toolBar.add(new JButton(new ImageIcon("images/floppy-disk.png")));
		toolBar.add(new JLabel("Search"));//레이블 바로 생성
		JTextField tf = new JTextField("Write Text");//텍스트 필드
		tf.setToolTipText("찾고자 하는 문자를 입력하세요");
		toolBar.add(tf);
		//콤보 박스 생성
		JComboBox combo = new JComboBox();
		combo.addItem("Java");
		combo.addItem("C++");
		combo.addItem("Phthon");
		combo.addItem("Javascript");
		toolBar.add(combo);
		
		//툴팁 사용법시
		ToolTipManager manager = ToolTipManager.sharedInstance();//임폴트
		manager.setInitialDelay(100);//마우스에 댔을떄 언제 뜰거냐
		manager.setDismissDelay(1000);//언제 사라질지
		
		contentPane.add(toolBar,BorderLayout.NORTH); // 아래에 사용할 수 있게 전역변수 사용
		//툴바는 분리해서 사용이 가능하다
		
		
	}
	public static void main(String[] args) {
		new ToolBarTest();
	}
}
