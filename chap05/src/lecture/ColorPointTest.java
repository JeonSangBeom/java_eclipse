package lecture;
// ��� ����(���� ����� �������� �ʴ´�)
//�ֻ��� ���� Ŭ���� java.lang.Object
public class ColorPointTest {

	public static void main(String[] args) {
		Point point = new Point();
		point.set(10, 10); // private�� ���� �ֱ� ������ set�� �ٿ� ��� �Ѵ� / ����
		point.showPoint();//�����ص� ��ǥ��� �޼��� ��� /��� {10,10}
		//������ �Լ� -����� �Բ� �ٷ� ������ �Լ�
		
		
		//��� ���� colorPoint�� �����ε� �Ͽ� �Ӽ� �߰��Ͽ� ����غ���
		ColorPoint colorPoint = new ColorPoint(20,20,"blue"); 
//		ColorPoint colorPoint = new ColorPoint();// �θ� Ŭ�������� �̸� �Լ� �����ڿ� ���� �Է��ϸ� �Ʒ� �̿��� �޼��������� ���� �� �ִ� 
//		colorPoint.set(20, 20); // Point�� �Ӽ� �� �޼��� �Լ��� ����� ��
//		colorPoint.setColor("blue");
		
		//������ �����ϰ� ���� �տ� Ÿ��(Ŭ���� Ÿ��)�� ���� = �״��� �÷� ����Ʈ��� Ŭ������ �����Ҷ��� �տ� new�� ���δ� = �̰��� ������ �Լ��� �Ѵ�
		
		colorPoint.showColorPoint();
		System.out.println(colorPoint);
	}

}
