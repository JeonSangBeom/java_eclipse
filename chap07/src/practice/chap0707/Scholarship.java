package practice.chap0707;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Scholarship {
	private HashMap<String,Double> scoreMap = new HashMap<>();// <�̸��� ������ ������ �Ǵ� ����>
	private Scanner scanner = new Scanner(System.in);
	private String title;

	public Scholarship(String title) {
		this.title = title;
	}
	
	//�� �Է�(5��)
	private void record() {
		System.out.println(title+" ���б� ���� �ý����Դϴ�.");
		for(int i=0;i<5;i++) {
			System.out.print("�̸��� ������ �Է��Ͻÿ�. >>");
			String name = scanner.next();
			double score = scanner.nextDouble();
			scoreMap.put(name, score);
		}
	}
	//���
	private void select() {
		System.out.println("���л� ���� ���� ������ �Է��Ͻÿ�. ex) 3.2");
		double min = scanner.nextDouble(); // ���� �� ����
		System.out.println("���л� ����� �Ʒ��� �����ϴ�..");
		//hashmap �ݺ�
		Set<String> keys  = scoreMap.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String name = it.next();
			double score = scoreMap.get(name);
			if(score>=min) {
				System.out.print(name+"/");
			}
		}
		System.out.println();
	}
	public void run() {
		record();
		select();
	}
	//record
	//select
}






