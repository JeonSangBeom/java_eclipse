package lecture;
//�����ڸ� �ΰ� �����
public class Circle02 {
	int radius;
	String name;
	//constructor === ������
	//�����ڴ� ���� Ÿ���� ���� - �ڱ� �ڽ��� �����̴�
	//�������Լ� (�޼���� Ŭ������ �̸��� ���ƾ� �Ѵ�.)
	//������ �ۼ��� �����ϴ�. (�����ε�)
	//new �� ���� ��ü�� �����ɶ� �ѹ� ȣ�� ����(�ʱ�ȭ)
	//���� �Ʒ�ó�� ������ ���� ������ �����Ϸ��� �ڵ����� �ϳ� ���� ���� �ִ´�. (�װ��� default �����ڶ��Ѵ� - int�� ��� default�� ���� 0�̴�)
	
	public Circle02() { //�����ڴ� Ŭ���� ���Ӱ� ���ƾ��Ѵ�
		radius = 1;
	}

	public Circle02(int r, String n) {
		radius= r;
		name = n;
	}
	public double getArea() {
		return radius*radius*3.14;
	}
}
