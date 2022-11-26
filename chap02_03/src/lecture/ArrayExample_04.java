 package lecture;
// 다차원 배열 안 배열
public class ArrayExample_04 {
	public static void main(String[] args) {
		int arr[][] = new int[2][3]; // 두개를 만드는데 그 안에 3개를 넣겠다
		int arr02[][] = {{10,20,30},{100,200,300}}; //[2][3]과 같다
		System.out.println(arr02[0][1]); // 20출력
		arr[0][0]=100;
		arr[0][1]=200;
		arr[0][2]=300;
		
		arr[1][0]=2000;
		arr[1][1]=3000;
		arr[1][2]=4000;
		
//		System.out.println(arr[0][0]);
//		System.out.println(arr[0][1]);
//		System.out.println(arr[0][2]);
		
		//졸업 평점
		double score[][] = {{3.3,3.4},{3.5,3.6},{3.7,4.0},{4.1,4.2}};//[4][2]와 같다
				double sum = 0;
				for(int i=0;i<score.length;i++) {
					for(int j=0;j<score[i].length;j++) {
						sum+=score[i][j];
					}
				}
				System.out.println("score갯수"+score.length);// 4
				System.out.println("score합계 "+sum); // 29.8
				System.out.println(sum/(score.length*score[0].length)); // 3.725
				
				//계단식 배열일 경우
				int stepArray [][];
						stepArray = new int[4][];
						stepArray[0] = new int[1];
						stepArray[1] = new int[2];
						stepArray[2] = new int[3];
						stepArray[3] = new int[4];
						
						stepArray [0][0] = 0;
						stepArray [1][0] = 1;
						stepArray [1][1] = 2;
						stepArray [2][0] = 3;
						stepArray [2][1] = 4;
						stepArray [2][2] = 5; // 늘여쓰기
						stepArray [3][0] = 6; 
						stepArray [3][1] = 7; 
						stepArray [3][2] = 8; 
						stepArray [3][3] = 9; 
						
						int stepArray02[][] = {{0},{1,2},{3,4,5},{6,7,8,9}};//한줄로 쓸 경우
						for(int i=0;i<stepArray02.length;i++) {
							for(int j=0;j<stepArray02[i].length;j++) {
								System.out.print(stepArray02[i][j]+",");//계단식 배열 
							}
							System.out.println();
						}
						//1,2,
						//3,4,5,
						//6,7,8,9,
						
						
						//비정방형 배열
						int irregualArray[][] = new int[4][];
						irregualArray[0] = new int[3];
						irregualArray[1] = new int[2];
						irregualArray[2] = new int[3];
						irregualArray[3] = new int[2];
						
						irregualArray[0][0] = 10;
						irregualArray[0][1] = 11;
						irregualArray[0][2] = 12;
						irregualArray[1][0] = 10;
						irregualArray[1][1] = 21;
						irregualArray[2][0] = 30;
						irregualArray[2][1] = 31;
						irregualArray[2][2] = 32;
						irregualArray[3][0] = 40;
						irregualArray[3][1] = 41;
						
						int irregualArray02[][] = {{10,11,12},{20,21},{30,31,32},{40,41}};
						for(int i=0;i<irregualArray02.length;i++) {
							for(int j=0;j<irregualArray02[i].length;j++) {
								System.out.print(irregualArray02[i][j]+",");
							}
							System.out.println();
						}
//						for(int i=0;i<irregualArray.length;i++) {
//							for(int j=0;j<irregualArray[i].length;j++) {
//								irregualArray[i][j] = (i+1)*10+j;
//							} // 글값을 입력
//															}
//						for(int i=0;i<irregualArray.length;i++) {
//							for(int j=0;j<irregualArray[i].length;j++) {
//								System.out.println(irregualArray[i][j]+","); // 출력
//							}
//							System.out.println();
//						}
//						10,11,21
//						20,21
//						30,31,32
//						40,41
	}	
}
