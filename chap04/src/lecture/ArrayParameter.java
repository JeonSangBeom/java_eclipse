package lecture;
//�⺻Ÿ���� ���� ���۷��� Ÿ���� ���� ����
public class ArrayParameter {
	
	static void replaceSpace(char chList[]) {
		for(int i=0;i<chList.length;i++) {
			if(chList[i]==' ') {//�ݺ��ؼ� ���ٰ� ������ ������
				chList[i]=','; // �޸��� ����(����)
			}
		}
	}
	static void printCharList(char chList[]) {//����ϰ� ���ִ� �Լ�
		for(int i=0;i<chList.length;i++) {
			System.out.print(chList[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) { // �����Լ�
		char chList[] = {'m','e','r','r','y',' ','c','h','r','i','s','t',' ','m','a','s'};
		printCharList(chList); //merry christ mas
		replaceSpace(chList);
		printCharList(chList); //merry,christ,mas
	}
}
