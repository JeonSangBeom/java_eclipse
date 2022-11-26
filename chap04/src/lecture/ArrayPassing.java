package lecture;

public class ArrayPassing {
	//기본타입 복사 설명
	static void arrayIncrease(int array[]) {
		for(int i=0;i<array.length;i++) {
			array[i]++;
		}
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};//갯수를 모를때에는 이렇게 사용한다
		//int arr02[] = new int[5]; 위와 같은 것
		arrayIncrease(arr); // 객체 할당으로 참조
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"==");//2==3==4==5==6== 출력
		}
	}
}
