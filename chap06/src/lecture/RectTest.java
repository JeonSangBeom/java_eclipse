package lecture;
 //�簢�� �ΰ��� ������(����) �׽�Ʈ - equals ����

class Rect {
	private int width; // �Ӽ��� ���鶩 �ǵ��� private�� ���
	private int height;
	
	//�������Լ�
	public Rect(int width, int height) { // �����ڴ� public �׸��� class���Ӱ� ���� Rect���
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "Rect [width=" + width + ", height=" + height + "]";
	}

	@Override
	public boolean equals(Object obj) {//equals�� ����ϴµ� Object�� �ްڴ� ��(Object�� �ִ� �޼����̱� ������)
		Rect tempRect = (Rect)obj;//�� ��ȯ �ʿ� Object�� �ֻ��� ��ü�̱� ������ �ƹ��� ��� �� �� �ֱ� ���� - �ٿ� ĳ����
		//tempRect�� ������ ���̱� ������ �Ʒ� width�տ� tempRect�� ���� �Ⱥٿ��� �ȴ�
		//���� ������ ���Ҽ� �ִ� ���ϻ� ���� ���� width�� height�� �ٶ󺸱� ����
		if(width*height == tempRect.width*tempRect.height) return true; 
		return false;
	}
}

//�׽�Ʈ ����
public class RectTest { // �̰� Ŭ���� ���Ӱ� Ŭ���� ���� ��ü �̸��� ���ƾ� �Ѵ�
	public static void main(String[] args) {//static�� Ŭ���� ����
		Rect rect01 = new Rect(10,10);
		Rect rect02 = new Rect(5,20);
		System.out.println(rect01==rect02); // false ���
		System.out.println(rect01.equals(rect02));
		System.out.println(rect01);
	}
}
