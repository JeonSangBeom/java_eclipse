package lecture;
//LinkedList 사용법 ArrayList와 비슷
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

//collection - 마구잡이로 넣어서 사용할 수 있다
//속도는 배열이 더 빠르다 / 크기 자동 조절 가능의 장점이 있다 
//제네릭(generics)기법으로 구현
//컬렉션의 요소는 객체만 가능 - 기본타입 불가 /다만 wapper은 가능 
public class CollectionTest {
	public static void main(String[] args) {
		LinkedList<String> movieList = new LinkedList<>();
		movieList.add("미나리");
		movieList.add("기생충");
		movieList.add("킹스맨");
		movieList.add("아바타");
		movieList.add("터미네이터");
		
		//가나다라 순으로 정렬하는 방법 sort(static이다)
		Collections.sort(movieList); 		
		Iterator<String> it = movieList.iterator();
		while(it.hasNext()) {
			String title = it.next();
			if(it.hasNext()) System.out.print(title+"=>"); // it 다음께 있으면 =>를 달고 
			else System.out.print(title);// 그게 아니라면 title만 달아라
		}//기생충=>미나리=>아바타=>킹스맨=>터미네이터 출력
		System.out.println();
		
		//뒤집는 방법 reverse(static이다)
		Collections.reverse(movieList);
		Iterator<String> it02 = movieList.iterator();
		while(it02.hasNext()) {
			String title = it02.next();
			if(it02.hasNext()) System.out.print(title+"=>");
			else System.out.print(title);
		}//터미네이터=>킹스맨=>아바타=>미나리=>기생충 출력
		System.out.println();
		
		//찾기 - 나중에 다시 검색해서 알아볼 것
		int idx = Collections.binarySearch(movieList, "킹스맨");//(처음건 리스트, 두번쨴 찾을 것)
		System.out.println("킹스맨은 "+(idx+1)+"번째 영화입니다.");
	}
}
