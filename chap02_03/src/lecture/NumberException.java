package lecture;

public class NumberException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strNum[] = {"23","12","3.14","100"};
		int i= 0;//catch ���� ���� ã�� �� ��� ���������� ������ �־�� �Ѵ� /for�� �� int �����־�� �Ѵ�
		try {	
		for(i=0;i<strNum.length;i++) { // �̰����� int�� �����ϸ� �� for�� �� �ȿ����� int�� ����� �� �ִ�
			int num = Integer.parseInt(strNum[i]);
			System.out.println("���ڷ� �ٲ� ����=="+num);
		}
		}catch(NumberFormatException e) {// ���� NumberFormatException -> Exception �� �Է��Ͽ� ����Ѵ�
			System.out.println(strNum[i]+"�� ������ ��ȯ�� ���� �ʽ��ϴ�.");
			//e.printStackTrace(); =>Exception�� �Է��Ͽ� ����� ��� �ý��� �ƿ� ��� ���
	}
}

}
