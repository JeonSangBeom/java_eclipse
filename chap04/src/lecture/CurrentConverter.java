package lecture;

public class CurrentConverter {
	private static double rate = 1100; // ����ȯ��
	public static double toDollar(double won) { 
		return won/rate;
	}
	public static double toKRWon(double dollar) {
		return dollar*rate;
	}
	//public static �̺κ��� ���� ���ϴ� �� �׵� Ÿ�԰� ���� �׸��� �Ű������� �߿�
	
	//get or set�� �̿��Ͽ� ȯ���� ���ص� private�� ���� �Ҽ� �ְ� ���ش�
	public static double getRate() {  //�б� ����(�̰͸� ������� �б⸸ �����ϴ�)
		return rate;  
	}
	public static void setRate(double rate) {//�б� ���� �� ����(���� �����ϰ� ���ش�)
		CurrentConverter.rate = rate;
	}
}
