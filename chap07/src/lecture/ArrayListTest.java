package lecture;
//ArrayList����
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//���� �迭�� �ٸ� �� - �迭 Ȯ�� (�������� �������ش� / ������ ���� ����)
//������ ���ؼ� ���� ã�� ���
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> strList = new ArrayList<String>();//<> - ���̾Ƹ�� �����ڶ� �Ҹ���
		Scanner scanner = new Scanner(System.in);
		//while�� �ٲ㼭 �Է��� �̸��� �׸� ������ ���������� �Է��� �̸��� �� �ⷫ�غ���.
		//for(int i=0;true;i++) { -> while�� ������� �ʰ� true�� �ᵵ ����� ���ִ�
		while(true) {
			System.out.println("�̸��� �Է��ϼ���.");
			String name = scanner.nextLine();
			if(name.equals("�׸�")) break;
			strList.add(name);
		}
		// �ݺ��Ͽ� �Է��� �̸� Ȯ��
		for(int i=0;i<strList.size();i++) { 
			String name = strList.get(i); // ���� ������
			System.out.print(name+"/");
		}
		// ���ھ� �� �̸� Ȯ�ι�
		int longIdx = 0;//���� �� �ϳ� ����
		for(int i=0;i<strList.size();i++) {// �ϳ��� �ݺ��ϸ�
			if(strList.get(longIdx).length() < strList.get(i).length()) {// ���� ������ 0�� ���̿� �Է��� �̸��� ���̸� �ϳ��� �� �Ͽ�
				longIdx = i; // ���� �� �� i�� longIdx�� �ִ´�
			}
		}
		
		System.out.println("���� �� �̸���==="+strList.get(longIdx));
		
		//Vector ArrayList ó�� ��ȯ ������ ������ ���� Iterator�� ������ �ִ�  
		
		//Map�� �������� ����. ��� �̷��� (Ű : value) �ΰ��� ���� �Է��Ͽ� ����Ѵ�
		//size�� ������� �ʰ� �ݺ����� ������ ��
		Iterator<String> it = strList.iterator(); 
		System.out.println(it.hasNext());// hasNext - ������ ������ true��ȯ  / ��� true
		while(it.hasNext()) {//�������� ������ �ݺ�(��ȯ�� �����Ҷ����� �ѷ��ش�)
			System.out.print(it.next()+"/");// �Է��� �� ��� ���� ����
		}
	}
}







