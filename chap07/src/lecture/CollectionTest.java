package lecture;
//LinkedList ���� ArrayList�� ���
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

//collection - �������̷� �־ ����� �� �ִ�
//�ӵ��� �迭�� �� ������ / ũ�� �ڵ� ���� ������ ������ �ִ� 
//���׸�(generics)������� ����
//�÷����� ��Ҵ� ��ü�� ���� - �⺻Ÿ�� �Ұ� /�ٸ� wapper�� ���� 
public class CollectionTest {
	public static void main(String[] args) {
		LinkedList<String> movieList = new LinkedList<>();
		movieList.add("�̳���");
		movieList.add("�����");
		movieList.add("ŷ����");
		movieList.add("�ƹ�Ÿ");
		movieList.add("�͹̳�����");
		
		//�����ٶ� ������ �����ϴ� ��� sort(static�̴�)
		Collections.sort(movieList); 		
		Iterator<String> it = movieList.iterator();
		while(it.hasNext()) {
			String title = it.next();
			if(it.hasNext()) System.out.print(title+"=>"); // it ������ ������ =>�� �ް� 
			else System.out.print(title);// �װ� �ƴ϶�� title�� �޾ƶ�
		}//�����=>�̳���=>�ƹ�Ÿ=>ŷ����=>�͹̳����� ���
		System.out.println();
		
		//������ ��� reverse(static�̴�)
		Collections.reverse(movieList);
		Iterator<String> it02 = movieList.iterator();
		while(it02.hasNext()) {
			String title = it02.next();
			if(it02.hasNext()) System.out.print(title+"=>");
			else System.out.print(title);
		}//�͹̳�����=>ŷ����=>�ƹ�Ÿ=>�̳���=>����� ���
		System.out.println();
		
		//ã�� - ���߿� �ٽ� �˻��ؼ� �˾ƺ� ��
		int idx = Collections.binarySearch(movieList, "ŷ����");//(ó���� ����Ʈ, �ι��� ã�� ��)
		System.out.println("ŷ������ "+(idx+1)+"��° ��ȭ�Դϴ�.");
	}
}
