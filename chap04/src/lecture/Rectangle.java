package lecture;
//�Է� �޾Ƽ� ���� ����� �� �����
public class Rectangle { //static
	int width;
	int height;
	
	public Rectangle() {//������ �Լ��� �����(Ŭ���� ���Ӱ� ����) / heap
		System.out.println("�簢���� ����� �����ϴ�.");
	}
	
	public int getArea() { //stack
		return width*height;
	}
}
