package casting;
//instanceof ����
class Person01{}//���� Ŭ����
class Student01 extends Person01{}
class Researcher extends Person01{}
class Professor extends Researcher{}// �̷��� ����ϸ� Professor�� person01 researcher professor �̷��� �������� �ش��� �ǰ� �ȴ�

public class InstanceOfTest {
	static void printPerson(Person01 p) { // static�� void��� Ÿ������ printPerson�� �̸��� ���� (person01Ŭ���� Ÿ��(Ÿ���ϻ�)�� p(�Ű�����))���� 
		//upcasting - Person01�� �ƴ� Studen01�� ���� �� �Ʒ� ������ ���� Researcher�� Professor �� Ÿ���� �� �� ����
		if(p instanceof Person01) System.out.println("Person01"); 
		// �Ѱ� ���� p ���� Person01(��ü-���۷��� Ÿ��)�� ã�� �� / instanceof�� ��ü Ÿ��(�⺻Ÿ�Կ��� ����� �� ����)�� ������ Ȯ�� �ϴ� ��
		// P(�̰��� �Էµ� �Ű�����)�� Person01�̶�� Ÿ���� �ִ��� ã�� ��(instanceof ����)
		if(p instanceof Student01) System.out.println("Student01"); 
		if(p instanceof Researcher) System.out.println("Researcher"); 
		if(p instanceof Professor) System.out.println("Professor"); 
		System.out.println();//�پ�� �뵵
	}
	public static void main(String[] args) {
		System.out.print("new Student01()===>"); 
		printPerson(new Student01()); //�Լ� / new Student01�� ��ü�� ����
		System.out.print("new Researcher()===>"); 
		printPerson(new Researcher()); 
		System.out.print("new Professor()===>"); 
		printPerson(new Professor()); 
		
	}

}
