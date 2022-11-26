package lecture;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest02 {
	//gson(���ۿ��� ���� ���̺귯��) - hashMap�� json���� �������� ��
	//�ڷγ�  [{aa:10},{aa:30},{aa:100}]
	public static void main(String[] args) {
		HashMap<String,Integer> score = new HashMap<>();
		score.put("����ȭ", 50);//Ű, �� �Է�
		score.put("�ֹ���", 70);
		score.put("�̼���", 80);
		score.put("������", 45);
		score.put("������", 85);
		System.out.println(score.size());// 4 ���
		
		//hashMap �ݺ��� ��� �ݺ��ؼ� ������ ���
		Set<String> keys = score.keySet();  // keySet -> score���� key���� �̾� �� ��  / Set�� �ݺ���Ҹ� ������� �ʴ´�(ex)���� ������) - ��� �Ұ�
		Iterator<String> it = keys.iterator(); // Set���� ���� ������ �ؾ� ��� ����
		while(it.hasNext()) {// ������ ������ true 
			String name = it.next();// it.next();�� ����Ű�� ���� Ű�����̴�
			int num = score.get(name); // Ű�� �־��ָ� ���� ������ִµ� �װ��� num�� �ֱ�
			System.out.println(name+":"+num); // ������ ������ ���� �ʴ� 
		}
	}
}
