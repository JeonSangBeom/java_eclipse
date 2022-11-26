package practice.chap0705;
//값을 입력 받는 곳
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentManager {
	private ArrayList<Student> university = new ArrayList<>(); // 저장할 공간 (객체로 바로 받아 사용-객체는 다른 클래스에 만들어 둔 상태)
	private Scanner scanner = new Scanner(System.in);
	private int total=4;// 미리 4개 설정
	
	/// test용도 잘되는지 확인
	public void test() {
		String temp = "장성호,자바,1,4.4";
		StringTokenizer st = new StringTokenizer(temp,",");
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
	}
	
	//private로 막아두면 개별적으로 불러올 수 없이 한꺼번에 출력을 하게 강제성을 줄 수 있다
	//값 입력  record();
	private void record() {
		System.out.println("학생 이름, 학과, 학번, 평균을 입력하세요. ex) 장성호,자바,1,4.4");
		for(int i=0;i<total;i++) {
			System.out.print(">>");			
			String studentInfo = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(studentInfo,","); //StringTokenizer(나눠주는 역할) / split도 사용 가능
			// 나눈 문자열을 담아 두기
			String name = st.nextToken().trim();// nextToken()=다음요소 확인  /  trim() = 공백제거 해주는 역할(혹시 몰라서)
			String dept = st.nextToken().trim();
			int id =  Integer.parseInt(st.nextToken().trim());// 문자로 들어오는데 정수로 넘어줘야 하기 때문에 이렇게 받아 준다
			double avg =  Double.parseDouble(st.nextToken().trim());
			university.add(  new Student(name, dept, id, avg)  ); // arraylist에 넣어주기(객체 생성자함수에 맞춰 넣어주기)
		}
	}
	
	//학생정보 전체 출력  printAll();
	private void printAll() {
		Iterator<Student> it = university.iterator();
		while(it.hasNext()) {// 다음이 있으면 반복
			Student student = it.next();// 반복될 녀석을 여기에 담아 하나씩 아래에 나눠 넣어 출력
			System.out.println("----------------------------");
			System.out.println("이름 : "+student.getName());// getter and setter로 만들어둔 get
			System.out.println("학과 : "+student.getDepartment());
			System.out.println("학번 : "+student.getId());
			System.out.println("평균 : "+student.getAvg());
			System.out.println("----------------------------");
		}
	}
	
	//학생 데이터 하나 읽어서 이름, 학과 , 아이디, 평균 printOne();
	private void printOne() {
		while(true) {
			System.out.println("학생 이름을 알려주시면 정볼를 보여드립니다. ex) 장성호");
			String name = scanner.nextLine();// 입력 받기
			if(name.equals("그만")) break;
			for(int i=0;i<university.size();i++) {
				Student student = university.get(i);// 하나씩 넣어 반복하여 확인
				if(student.getName().equals(name)) {// 입력받음 사람과 이름이 같을 경우 아래 출력
					System.out.println("이름 : "+student.getName());// getter and setter로 만들어둔 get
					System.out.println("학과 : "+student.getDepartment());
					System.out.println("학번 : "+student.getId());
					System.out.println("평균 : "+student.getAvg());
				}
			}
		}
	}
	private String addZero(int num) {
		if(num<10) {
			return "0"+num;
		} else {
			return ""+num;
		}
	}
	
	//불러주는 역할 
	public void run() {
		record();
		printAll();
		printOne();
	}
	
	
	
}










