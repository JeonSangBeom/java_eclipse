 package lecture;
//��� ����(���� ����� �ȵȴ� / �� �θ𿡰Լ��� �����´�)

public class Point {
	//field, properties, ����, ����, �ν��Ͻ� ���� �� �Ҹ���
	private int x;//�ܺο��� ������ �ȵȴ�
	private int y;
	
	public void set(int x, int y) { // �������� ����
		this.x = x;
		this.y = y;
	}	
	public void showPoint() { //�����ֱ� ���� �޼���(x,y��ǥ�� ����ְ� �ִ�)
		System.out.println("{"+x+","+y+"}"); 
	}
	
	//super�� �θ� ��
	public Point() {		
	}
	public Point(int x, int y) {// ���� set�Լ��� ���� set�� �ᵵ �ǰ� Point�� �ᵵ �ǰ� ����� ����
		this.x = x;
		this.y = y;
	}
}
