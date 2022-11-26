package lecture;
//private 설명
public class SampleTest {

	public static void main(String[] args) {
		//Sample.d- 불러와 진다
		System.out.println(Sample.d);//클래스로 접근한 생성자는 따로 선언 뒤에 나올 필요 없이 이렇게 위에서 바로 사용 가능하다
		Sample sample = new Sample();
		//sample.a,c는 이 아래에서만 가능 d는 여기서도 가능
		
	}

}
