package lecture;
//기본타입은 복사 래퍼런스 타입은 참조 설명
public class ArrayParameter {
	
	static void replaceSpace(char chList[]) {
		for(int i=0;i<chList.length;i++) {
			if(chList[i]==' ') {//반복해서 가다가 공백이 나오면
				chList[i]=','; // 콤마를 찍어라(대입)
			}
		}
	}
	static void printCharList(char chList[]) {//출력하게 해주는 함수
		for(int i=0;i<chList.length;i++) {
			System.out.print(chList[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) { // 실행함수
		char chList[] = {'m','e','r','r','y',' ','c','h','r','i','s','t',' ','m','a','s'};
		printCharList(chList); //merry christ mas
		replaceSpace(chList);
		printCharList(chList); //merry,christ,mas
	}
}
