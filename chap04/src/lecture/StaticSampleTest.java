package lecture;
//static ����
public class StaticSampleTest {

	public static void main(String[] args) {
		StaticSample st01;//�����
		StaticSample st02;
		st01 = new StaticSample();// ���� (���� �Ⱦ��� ���� ����)
		st01.n = 5;
		st01.g();
		//static = ���� ����, ���� �޼���
		System.out.println("st01 m=="+StaticSample.m); //Ŭ���� �������� �����ϴ� ���� ���������� �ȴ�(���� �׷��� ��ü�� ���ϰ� Ŭ���� �������� �����Ͽ� ���̵� ����Ѵ�)
		System.out.println("st01 n=="+st01.n);
		st02 = new StaticSample();
		st02.n= 1000;
		st02.f();// st02�� �ٲ㵵 ���������� ������ �����̱� ������ �� ���� �ٲ��
		System.out.println("st01 m=="+StaticSample.m);
		System.out.println("st02 m=="+StaticSample.m);
	}
}
