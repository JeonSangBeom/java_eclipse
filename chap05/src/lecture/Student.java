package lecture;

import java.util.Scanner;

//��� ����
public class Student extends Person{//Person�� ��� �ްڴ�
	public Student() {
		System.out.println("���� Person�� ��ӹ��� �л� Ŭ����");
	}
	public void set() {
		this.age = 30; // this.�� ���� person���� ���� �� �ִ� ������ �� �� �ִ� (�Ƚᵵ ����� ����)
		setWeight(80); //private�� set���� ��ȯ�Ͽ� ����Ѱű� ������ �տ� set�� �޼����̱� ������ ��ȣ�� ����� �ش�
		name = "�����";
		height=180;		
	}
	
	public static void main(String[] args) {
		//�⺻ ���� ����
		Person p = new Person();
		Person a = new Person("��");
		System.out.println(a.name);
		
		Person n = new Person("��",1);
		System.out.println(n.name+n.age);
	
		
		//���� ����
		Person poo[] = new Person[3];
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<poo.length;i++) {
			System.out.println("�̸��� �Է��Ͻÿ�");
			String name = scanner.nextLine();
			poo[i] = new Person(name);
		}
		for(int i=0; i<poo.length;i++) {			
			System.out.println(poo[i].name);
		}
		scanner.close();
	}

}
