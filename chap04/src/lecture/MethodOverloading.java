package lecture;
//�޼��� �����ε� ����
public class MethodOverloading {
	//�޼��� �����ε��� �޼����� �̸��� ���� �Ű������� ������ Ÿ���� �ٸ���....
	//���� Ÿ���� �������...
	public int getSum(int a, int b) { //������ ���� / ������ ������ ���� ���ö� getSum�� ����Ѵ�
		return a + b;
	}
	public int getSum(int a, int b, int c) {
		return a + b + c;
	}
	public double getSum(double a, double b) {
		return a + b;
	}
//	public double getSum(int a,int b) {//�Ű������� ���� �����ε��� �ȵȴ�
//		return (double)(a+b); ����ȯ ���(int�� double��)
//	}
}
