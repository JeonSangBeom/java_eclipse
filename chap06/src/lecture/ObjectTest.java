package lecture;

class Point { // ���� ����� ���� ���� �⺻�̳� ���� �� �� �ִ� ��� �տ� �ۺ����� ���� �����ڴ� ��� �Ұ�
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override//���� ����ٴ� ����
	//alt+shift+s -> Generate toString Ŭ���Ͽ� ����
	public String toString() { //(obj.toString())�� �̿��ҽ� �ڽ��� ��(point)���� ���� �����ش� ���ҽ� Ȯ�� �Ұ�(���� Point [x=10, y=20] ���)
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	//���������� �Է�
	public boolean equals(Object obj) {//boolean - true �� false�� ���� �����Ͽ� ã�� ���̴� boolean�� ����� �Ѵ�
		Point tempPoint = (Point)obj;//������ ���� ���� Ŭ���� ����Ʈ�� ���� obj�� �ٿ�ĳ��Ʈ�� ���ش�
		// object�ȿ��� x��� �Ӽ��� ���� ������ ����ȯ�� �ϰ� �ȴ� - �ٿ� ĳ����
		if(x==tempPoint.x && y==tempPoint.y) return true; // x�� point�ȿ� �ִ� �Ű����� x�� ���� �������� ��
		return false;
	}
	
}
public class ObjectTest {
	//objŬ���� ����
	public static void print(Object obj) { //Object - ��� ����(�̰� ���� Object�κп� ���� ������ point�� ���� �� �ִ�) / static�� �ҷ��÷��� static���� ���� ������ ���ƾ� �Ѵ�
		//obj�� ������ �ִ� �⺻ �Լ���
		System.out.println(obj.getClass().getName()); //lecture.Point ��� - lecture��ü ���� Point��� ���� obj�� �̸��̶��� �� �� �ִ�
		System.out.println(obj.hashCode()); // �޸� �ּ� ��(����1586600225 ���) - ���� ������ ���� ���� �ٶ� ���� �ִ� ������ ����
		System.out.println(obj.toString()); // ���ڷ� �ٲٸ� ��� �Ǵ���(�������̵带 ����� ��Ȯ�� �Ӽ��� �� �� �ִ�
		System.out.println(obj); //obj��ü�� ��� �Ǵ��� - toString�� ���� ���� ��������(�ΰ��� ���� lecture.Point@5e91993f ���)
	}
	public static void main(String[] args) {
		Point point01 = new Point(10,20);
		Point point02 = new Point(10,20); //point01�� 02�� �ٸ��� new�� ���Ӱ� ������ �ϴ� ���̱� ������ �ΰ��� ������ �����ȴ�(heap����) ���� ���Ƶ� ���� �ٸ� ��
		Point point03 = point01; // ����
		//equals ����
		System.out.println(point01==point02);//false ���
		System.out.println(point01==point03);//true ���
		System.out.println(point01.equals(point02));//true ��� - equals�� ���ٶ��̵� ����߸� true�� ���� ���´�(hashCode�� �ٸ����� ���� ���ϱ� ����)
		
		//obj���� ���
		print(point01); // ������ �Լ� �� �����ڵ��� �⺻ println���� ����Ѵ�
	}
}







