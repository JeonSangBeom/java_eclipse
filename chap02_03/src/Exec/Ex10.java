package Exec;

public class Ex10 {

	public static void main(String[] args) {
		int arr[][]=new int[4][4];
		int arr2[]=new int[10];
				int x,y; //배열의 랜덤한 위치에 생성할 것임
		
		for(int i=0; i<10; i++) {
			arr2[i]=(int)(Math.random()*10+1);
		}
		for(int i=0; i<10; i++) {
			x=(int)(Math.random()*4);
			y=(int)(Math.random()*4);
			if(arr[x][y]==0) {
				arr[x][y] = arr2[i];
			}
			else {
				i--;
			}
					
		}
		for(int i=0; i<arr.length;i++) {
			for(int j = 0; j<arr[i].length;j++) {
				System.out.println(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
