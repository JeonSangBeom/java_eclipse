package lecture;

public class Person {
	//����������(������)�� ����
	private int weight;//�ܺο� ���� �ȵȴ� �̷� �ʵ带 ���� getter/setter(�޼���)�� ����� �־�� �Ѵ�
	int age; // �տ� �ƹ��͵� ���� ������� default�� �ȴ�
	protected int height;
	public String name;
	
	//lombox( getter setter �� ���ϰ� ����� �� �ְ� �ϴ� ���̺귯�� - ���߿� ��ġ�Ͽ� �ַ� ����Ѵ�)
	
	//������ �Լ�(���� �ʱ�ȭ�Ҷ� ����� �ش� - ���� Ÿ���� ����)
	public Person() {
		System.out.println("���� ���"); 
	}
	
	//������ ����
	public Person(String name, int weight) {
		this.name = name;
		this.age = age;
		System.out.println("���� ���"); //�̷������� ������ �Լ��� �̸� ���ϸ� ����� ���Ҷ� �����Կ� �̸��� �̸� ���� �� �ִ�
	}	
	//����
	public Person(String name) {
		this.name = name;
	}
	
	
	//alt+shift+s get or set������ �ڵ� ���� ����
	public int getWeight() {//get�� �ҷ� ���� �ű� ������ ���� �Ű������� ���� �ʴ´� / �� ���� �˷��ִ� ������ �ϱ� ������ Ÿ���� ���־�� �Ѵ�
		return weight; //�Ű������� ���� ������ this�� �����ϰ� ���� ����
	}
	public void setWeight(int weight) { //���� �����Ҷ� void ��� set�� �̿��Ͽ� private���� �ҷ��� ����ϰ� �Ѵ�
		this.weight = weight; //private���� �ٷ� ���� �ҷ��� ���� ������ �̷��� set�޼��带 �̿��Ͽ� ���� �ҷ��� �� �ִ�
	}	
	//getter(���� �ޱ⸸ ��)/setter(���� �ް� �ٲ� �� ������ ���)
	

}
