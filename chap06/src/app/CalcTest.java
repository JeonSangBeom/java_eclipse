package app;
//GoodCalculator�� ������ ���� �����ͼ� ���� �ϱ�
import lib.Calculator;
//extends�ʿ� ���� �ҷ� �� �� �ֱ� ������(���� ���� �ȿ� �ֱ� ������) �����Ͽ� ����Ѵ�

//design  pattern(���� ��� ���� å)
public class CalcTest {

	public static void main(String[] args) {
		Calculator calc = new GoodCalculator();// �տ� Calculator�� �ᵵ �ǰ�  GoodCalculator�� �ᵵ ��� ���� -upcasting
		//GoodCalculator �� Calculator�� ��� �޾ұ� ������ �������(�θ�Ÿ���� Calculator - �θ� �������� �ڽĵ� ���� ������ �� �ִ�)
		System.out.println(calc.add(10, 20));
	}
}
