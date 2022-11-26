package lecture;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest02 {
	//gson(구글에서 만든 라이브러리) - hashMap을 json으로 리턴해준 것
	//코로나  [{aa:10},{aa:30},{aa:100}]
	public static void main(String[] args) {
		HashMap<String,Integer> score = new HashMap<>();
		score.put("이중화", 50);//키, 값 입력
		score.put("최문성", 70);
		score.put("이성규", 80);
		score.put("심재훈", 45);
		score.put("심재훈", 85);
		System.out.println(score.size());// 4 출력
		
		//hashMap 반복문 대신 반복해서 돌릴떄 사용
		Set<String> keys = score.keySet();  // keySet -> score에서 key값만 뽑아 온 것  / Set은 반복요소를 허용하지 않는다(ex)위에 심재훈) - 출력 불가
		Iterator<String> it = keys.iterator(); // Set으로 먼저 지정을 해야 사용 가능
		while(it.hasNext()) {// 다음께 있으면 true 
			String name = it.next();// it.next();가 가리키는 것은 키값만이다
			int num = score.get(name); // 키를 넣어주면 값을 출력해주는데 그것을 num에 넣기
			System.out.println(name+":"+num); // 순서는 정해져 있지 않다 
		}
	}
}
