package lecture;
//Vector ����
import java.util.Vector;
public class VectorTest {
	public static void main(String[] args) {
		//collection�� ������ ��ü�� - �⺻Ÿ�� �Ұ��� <> -> �� �ȿ� 
		//���� ���س��� ���� ����...
		//Vector �� arrayList�� ����ϴ� ���� ����
		//���� ������ �������� �迭�� ���� �׷��� ���� ��쿣 �̷��� vector�� arraylist�� ����ϴ� ���� ����
		Vector <Integer> vec = new Vector<Integer>();//���͸� ���� �� <Ÿ�Լ���>- <> = ���׸� ���
		Vector <String> vec02 = new Vector<String>(); 
//		Vector <String> vec02 = new Vector<>(); // �̷��� ������ �Ͽ� ����Ͽ��� ��� ���� - �ڹٿ��� �˾Ƽ� �ν� 
		vec.add(1);
		vec.add(2);
		vec.add(3);
		vec.add(10);
		vec02.add("�强ȣ");
		vec02.add("�輺ȣ");
		vec02.add("�̼�ȣ");
		vec02.add("�ڼ�ȣ");
		vec02.add("�ּ�ȣ");
		vec02.add("����ȣ");
		System.out.println(vec.capacity());
		System.out.println(vec02.capacity()); //capacity - 10�� ������ �޸𸮸� �߰� ��Ű�� ��
		for(int i=0;i<vec.size();i++) { // �Ѳ����� ã���� -> length�� �ƴ� size�� ����Ͽ��� �Ѵ�
			System.out.println(vec.get(i));// �̷��� get�� ����Ͽ� ã�� �� �ִ�
		}
		vec.add(2,1000);// 2° index�� 1000�� �Է��ϰڴ�
		for(int i=0;i<vec.size();i++) {
			System.out.println(vec.get(i));
		}
		for(int i=0;i<vec02.size();i++) {
			System.out.println(vec02.get(i));
		}
	}
}

////���
//10
//10
//1
//2
//3
//10
//1
//2
//1000
//3
//10
//�强ȣ
//�輺ȣ
//�̼�ȣ
//�ڼ�ȣ
//�ּ�ȣ
//����ȣ