package practice.chap0705HasMap;
//hashmap 사용
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class StudentManager {
	private HashMap<String,Student> university = new HashMap<>();
	private Scanner scanner = new Scanner(System.in);
	private int total=4;
	
	private void record() {
		System.out.println("학생 이름, 학과, 학번, 평균을 입력하세요. ex) 장성호,자바,1,4.4");
		for(int i=0;i<total;i++) {
			System.out.print(">>");
			String studentInfo = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(studentInfo,",");
			String name = st.nextToken().trim();
			String dept = st.nextToken().trim();
			int id =  Integer.parseInt(st.nextToken().trim());
			double avg =  Double.parseDouble(st.nextToken().trim());
			university.put(name, new Student(name, dept, id, avg) ); // add가 아닌 put이용
		}
	}
	private void printAll() {
		Set<String> keys = university.keySet(); // set 사용
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String name = it.next();// 키 값을 name에 넣고
			Student student = university.get(name);// 객체를 넣어준 키 값으로 불러와 사용
			System.out.println("----------------------------");
			System.out.println("이름 : "+student.getName());// getter and setter로 만들어둔 get
			System.out.println("학과 : "+student.getDepartment());
			System.out.println("학번 : "+student.getId());
			System.out.println("평균 : "+student.getAvg());
			System.out.println("----------------------------");
		}
	}
	private void printOne() {
		while(true) {
			System.out.println("학생 이름을 알려주시면 정보를 보여드립니다. ex) 장성호");
			String name = scanner.nextLine();
			if(name.equals("그만")) break;
			Student student = university.get(name);
			if(student==null) System.out.println("없는 학생입니다.");
			else {
				System.out.println("==========================");
				System.out.println("이름 : "+student.getName());// getter and setter로 만들어둔 get
				System.out.println("학과 : "+student.getDepartment());
				System.out.println("학번 : "+student.getId());
				System.out.println("평균 : "+student.getAvg());
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
	public void run() {
		record();
		printAll();
		printOne();
	}
	//媛� �엯�젰  record();
	//�븰�깮�젙蹂� 異쒕젰  printAll();
	//�븰�깮 �뜲�씠�꽣 �븯�굹 �씫�뼱�꽌 �씠由�, �븰怨�, �븘�씠�뵒, �룊洹� printOne();
}










