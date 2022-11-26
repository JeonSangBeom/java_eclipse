package lecture;
//File 설명
import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		File file = new File("C:/Windows/system.ini");
		System.out.println(file.getPath());//getPath - 경로 C:/Windows/system.ini
		System.out.println(file.getParent());//getParent - 부모 경로 C:/Windows
		System.out.println(file.getName());//getName - 이름 system.ini
		System.out.println();
		
		String isFile=null;		
		if(file.isFile()) isFile = "파일"; // isFile- 기본 메서드(boolean) 파일인지 폴더인지 알수 있다 파일이면 참
		else isFile="폴더";		
		System.out.println("isFile = " +isFile);
		System.out.println();
		
		File sampleFolder = new File("C:/Windows/Temp/sample");
		System.out.println(sampleFolder.getPath()+"의 하위 폴더 및 파일 리스트입니다."); // 경로 확인
		File subFiles[] = sampleFolder.listFiles();//listFiles() - 배열로 떨어뜨려 준다
		for(int i=0;i<subFiles.length;i++) { // 반복하여 배열로 떨어뜨린 것을 프린트 하기
			File innerFile = subFiles[i];
			System.out.println(innerFile.getName()+"=== 파일 용량 "+
			(int)(innerFile.length()/1024+1)+"kb");
		}
	}
}
