 package lecture;
//Calendar - �߻�Ŭ���� / ��¥�� ��� ��
import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();// new�� ���� �ʰ� getInstance�� ����� ������ ���ش�(Calendar�� �����ؾ� ��)
		//Calendar�� �߻� Ŭ����(�̸鼭 implements�� �������̽��� �Ǿ� �ִ�)�� ���ǰ� �Ǿ� �ִ�(�߻�Ŭ������ new�� ���ؼ� ������ ���� ����
		//getInstance static�� �����ؼ� �Լ��� �������� �ִ� �����̴�
		// get - ���´ٴ� ��
		
		// ���� �ҷ����� ��
		//������ now. ���� �����ؼ� �ҷ������� year = ���� �ؼ� ������ �� ���� �־��ִ� ����� ����Ѵ� 
		int year = now.get(Calendar.YEAR); 
		int month = now.get(Calendar.MONTH);
		int date = now.get(Calendar.DAY_OF_MONTH); // ���� ����
		int hour = now.get(Calendar.HOUR_OF_DAY); // 24�� ����
		int hour02 = now.get(Calendar.HOUR); // 12�� ���� �ð�
		int ampm = now.get(Calendar.AM_PM);
		int am = now.get(Calendar.AM);
		int pm = now.get(Calendar.PM);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);

		int day = now.get(Calendar.DAY_OF_WEEK);// ��¥
		System.out.println("day===" + day); // ������̶�� 7�� ���

		System.out.println(year + "==" + (month + 1) + "===" + date); // ��¥�� ����� ���� ���� ��� +1�� ����� �Ѵ� // �ش�⵵ ==== �ش� �� === �ش� ��
		System.out.println(hour02 + "==" + minute + "===" + second);
		
//		if(ampm==am) System.out.println("����");
//		else System.out.println("����"); // ��Ȯ�� ���ͳ� �˻� �ʿ�
		
				
		String days[] = {"��","��","ȭ","��","��","��","��"};
		System.out.println(days[day-1]); // �迭�� ��������� (day�� 1,2,3,4,5..�� �����ϱ� ������)
		
		switch (day) { // ��Ȯ�Ҷ� switch�� ����Ѵ� /  day�� ���ڷ� ��������
		case Calendar.SUNDAY:
			System.out.println("�Ͽ���");
			break;
		case Calendar.MONDAY:
			System.out.println("������");
			break;
		case Calendar.TUESDAY:
			System.out.println("ȭ����");
			break;
		case Calendar.WEDNESDAY:
			System.out.println("������");
			break;
		case Calendar.THURSDAY:
			System.out.println("�����");
			break;
		case Calendar.FRIDAY:
			System.out.println("�ݿ���");
			break;
		case Calendar.SATURDAY:
			System.out.println("�����");
			break;
		}
		
	}
}
