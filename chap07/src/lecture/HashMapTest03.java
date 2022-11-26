package lecture;
//HashMap <키,객체>사용법
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Student { // 객체 생성을 위한 클래스 생성
	private int id;
	private String tel;
	
	public Student(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}
	public int getId() { // set은 처음 정보 값으로만 사용
		return id;
	}
	public String getTel() {
		return tel;
	}
}
public class HashMapTest03 {
	public static void main(String[] args) {
		//장성호, new Student(1, "010-1111-2222");
		//이중화, 2, 010-2222-3333
		// 키와 객체 사용법
		HashMap <String,Student> studentMap = new HashMap<>();
		studentMap.put("이중화", new Student(1,"010-1111-1111"));
		studentMap.put("이성규", new Student(2,"010-2222-2222"));
		studentMap.put("최문성", new Student(3,"010-3333-3333"));
		studentMap.put("심재훈", new Student(4,"010-4444-4444"));
		
		//한꺼번에 출력하는 방법
		Set<String> keys =  studentMap.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			//System.out.println(it.next());
			String name = it.next(); // 변수에 넣어 사용하여야 오류가 발생하지 않는다 아닐시 중복 적용이 되어 하나씩 띄어서 나타남
			System.out.println(name+"=="+studentMap.get(name).getId()+":"+studentMap.get(name).getTel());
			//불러온 키 값의 이름의 Id+Tel
		}
		/*
		Scanner scanner = new Scanner(System.in);
		while(true) { // 반복문 시작
			System.out.println("검색할 이름을 쓰세요.");
			String name = scanner.nextLine();
			if(name.equals("exit")) break;
			Student student = studentMap.get(name); // 클래스 타입 과 변수 = get 이용 (검색가능한 키를 입력시 값(객체) 출력)
			if(student==null) System.out.println("우리반에 없어요... 넌 누구야...!!");
			else System.out.println(name+"님의 아이디는 "+
									student.getId()+"이고 전화번호는 "+ 
									student.getTel()+"입니다."
								   );
		}
		*/
	}
}







