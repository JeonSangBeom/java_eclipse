import java.util.Scanner; // class �ڹ� ��ƿ ��Ű�� �ȿ� �ִ� ��ĳ�� �ҷ��� ����ρٴ� ��

public class ScannerEx {

	public static void main(String[] args) {
		
		System.out.println("�̸��� �Է��ϼ���");
		Scanner scanner = new Scanner(System.in); // ���� instance ����
		 // �Է� ������ ���
		String name = scanner.next(); // ��ĳ�ʿ��� �Է� ���� ���� �ҷ��� ����Ҷ�
		System.out.println("���� �̸���" + name + "�Դϴ�");
		
		
		
		System.out.println("���̸� �Է��Ͻÿ�");
		int age = scanner.nextInt(); // ���� �Է� ���������� Int���
		System.out.println("�� ���̴�" + age + "�Դϴ�");

		
		System.out.println("�����Ը� kg ������ �Է��Ͻÿ� ex) 66");
		double weight = scanner.nextDouble(); // �Ǽ� �Է� ���� ��

		
		System.out.println("Ű�� ��ġ ������ �Է��Ͻÿ� ex) 180");
		double height = scanner.nextDouble();
		//18.5 ���� ������ ��ü��
		//23���� ������ ����
		//25 ��ü��
		//�������� �� ��
		double Height = height / 100;
	      double biman = weight / Height / Height;
	      
	      if(biman <18.5) {
	         System.out.println("��ü��");
	      } else if(biman < 23) {
	         System.out.println("����");
	      } else if(biman < 25) {
	         System.out.println("��ü��");
	      } else if (biman < 30) {
	         System.out.println("��");
	      } else {
	         System.out.println("����");
	      }
		System.out.println("�����Դ�" + weight + "�Դϴ�");

		scanner.close(); // ����� �޸𸮴� ������� �Ѵ�
		
		 /* 
		 */
		
		//���׿�����
		int a = -10;
		int b = 20;
		System.out.println(a > b ? a - b : b - a); //ù��° ������ �����ϸ� �տ� �� �ƴϸ� �ڿ� ���� ����Ѵ�
		// a�� b���� ũ�� a-b�� ���� �ƴϸ� b-a�� �Ͽ���
	}
}



