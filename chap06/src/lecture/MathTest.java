package lecture;
//math ���� - �⺻������ �˾Ƶξ�� �� ��
import java.util.Random;

public class MathTest {
	public static void main(String[] args) {
		System.out.println(Math.abs(10-21)); // abs - ���밪 // ��� 11
		//�̷��� �տ� �ٷ� Math�� ���� ���� static�� �з� �Ǿ� �ִ� ���̱� �����̴�
		System.out.println(Math.cos(1));//��� 0.5403023058681398
		System.out.println(Math.ceil(0.1));// 1.0 ���
		System.out.println(Math.round(0.5)); // 1 ���
		System.out.println(Math.floor(0.5)); //0.0 ���
		System.out.println("Math.random "+Math.random()*2);// 1.4219018932792993 ��� / ���� ��� �ٲ��
		System.out.println(Math.sqrt(2)); // ��Ʈ // 1.4142135623730951 ��� 
		System.out.println(Math.exp(2)); // 7.38905609893065 ���
		Random random = new Random(); // java�ȿ��� util�̶�� ���� Random�̶�� �Լ��� �����Ѵ�
		//System.out.println(random.nextInt()); // �ڹ� �ȿ��� �����̶�� �Լ���(util.Random) �����ؼ� �� ���� ���´�
		//System.out.println(random.nextInt(45)); - 45�߿� �ϳ��� ��� ��� �Ҷ�
		
	}
}
