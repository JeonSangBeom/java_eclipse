package lecture;

//�߻� Ŭ���� ����(2) - ������ ����
public class SamSongCalc extends Calculator {
	//SamSongCalc ���� �߻��� Ŀ���� ������ �뼭 ���� ������ ���� �����ϸ� �˾Ƽ� �������̵尡 ���õǾ� ��Ÿ����
	//Calculator�� ���ǵ� �߻� �޼���

	public int add(int a, int b) {
		return a + b;
	}
	@Override
	public int subtract(int a, int b) {
		int result = a > b ? a - b : b - a; //a�� b���� ũ�� a-b�� �ϰ� �׷��� ������ b-a�� �ض�
		return result;
	}
	@Override
	public double avg(int[] arr) {
		double sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return sum/arr.length;
	}
	public static void main(String[] args) {
		SamSongCalc sc = new SamSongCalc();
		System.out.println(sc.add(10,20));
		System.out.println(sc.subtract(23,78));
		System.out.println(sc.avg(new int[] {98,95,87}));///new int �ȿ� �迭 �ֱ�  
	}
	//���
//	30
//	55
//	93.33333333333333
}
