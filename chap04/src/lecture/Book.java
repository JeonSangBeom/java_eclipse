package lecture;

public class Book {
	//����� �۰�
	String title; // private�� ����� ��� booktest���� ��� �Ұ� �׷��� ���� getter and setter ����Ͽ��� ����Ѵ�
	String author; //�Ӽ� �ΰ� ����(������ ����)
	
	//���� ���ǽ� ���(���� �������̶� ���������� ����� ��)
	private String  name;
	private int age;
	private String address; //�ܺο��� �����ؼ� �� �� ���� (�ڱ� �ڽŸ� ���) //alt+shift+s -> getter and setter�� �̿��Ͽ� ���� ������ �־�� ��� ����
	
	//public (��ü ���� ����)
	
	public String getName() {//���ö� get���
		return name;
	}

	public void setName(String name) {//�޼��� ���� ����������-����Ÿ��-�̸�-�Ű�����
		this.name = name; //this�� ���� ��ܿ� ��ġ(��Ģ)
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Book() { // ����Ʈ ������ ����
		this("notitle","noname"); // �ȿ� �ƹ��͵� ���ٴ� ��(�ȿ��� �� �ٸ� �Ű������� public Book(String title, String author) ȣ�� ��)
		System.out.println("������ ȣ���...");
	}
	
	public Book(String title) {  //������ ���� ���� (�տ� ���������ڴ� �ǹ�)
		this.title = title;
		author = "���ڹ̻�";
	}
	public Book(String title, String author) { //�Ű������� Ÿ���� ������ ���� �߻� 
		this.title = title; //this.-Ŭ���� �ڽ��� ����Ų�� / �Ǵ� title�տ� '_'�� �ٿ� �д�(�Ű������� ������ ����(Ŭ����)�� �򰥸��� �ʰ� �ϱ� ���� ���)
		this.author = author;// ���� �Ӽ����� ������ this.author(�Ժη� �ٲܼ� ����)�� ���� �ִ� 
	}
	
	public void showBookInfo() { //�޼��� ���� (����������+����Ÿ��+�̸�)
		System.out.println("å������ "+title+"�̰� �۰��� "+author+"�Դϴ�.");
	}
	public void methodTest(int m) { //���� ����
		System.out.println(++m);
	} 
}









