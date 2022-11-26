package lecture;
//HashMap <Ű,��ü>����
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Student { // ��ü ������ ���� Ŭ���� ����
	private int id;
	private String tel;
	
	public Student(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}
	public int getId() { // set�� ó�� ���� �����θ� ���
		return id;
	}
	public String getTel() {
		return tel;
	}
}
public class HashMapTest03 {
	public static void main(String[] args) {
		//�强ȣ, new Student(1, "010-1111-2222");
		//����ȭ, 2, 010-2222-3333
		// Ű�� ��ü ����
		HashMap <String,Student> studentMap = new HashMap<>();
		studentMap.put("����ȭ", new Student(1,"010-1111-1111"));
		studentMap.put("�̼���", new Student(2,"010-2222-2222"));
		studentMap.put("�ֹ���", new Student(3,"010-3333-3333"));
		studentMap.put("������", new Student(4,"010-4444-4444"));
		
		//�Ѳ����� ����ϴ� ���
		Set<String> keys =  studentMap.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			//System.out.println(it.next());
			String name = it.next(); // ������ �־� ����Ͽ��� ������ �߻����� �ʴ´� �ƴҽ� �ߺ� ������ �Ǿ� �ϳ��� �� ��Ÿ��
			System.out.println(name+"=="+studentMap.get(name).getId()+":"+studentMap.get(name).getTel());
			//�ҷ��� Ű ���� �̸��� Id+Tel
		}
		/*
		Scanner scanner = new Scanner(System.in);
		while(true) { // �ݺ��� ����
			System.out.println("�˻��� �̸��� ������.");
			String name = scanner.nextLine();
			if(name.equals("exit")) break;
			Student student = studentMap.get(name); // Ŭ���� Ÿ�� �� ���� = get �̿� (�˻������� Ű�� �Է½� ��(��ü) ���)
			if(student==null) System.out.println("�츮�ݿ� �����... �� ������...!!");
			else System.out.println(name+"���� ���̵�� "+
									student.getId()+"�̰� ��ȭ��ȣ�� "+ 
									student.getTel()+"�Դϴ�."
								   );
		}
		*/
	}
}







