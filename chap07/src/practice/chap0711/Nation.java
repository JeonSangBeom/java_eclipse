package practice.chap0711;

public class Nation {
	//속성 두개 만들기 capital, country String
	//생성자 만들기
	//속성은 값을 얻어갈 수만 있게	
	private String capital;
	private String country;
	public Nation(String country,String capital) {
		this.capital = capital;
		this.country = country;
	}
	public String getCapital() {
		return capital;
	}
	public String getCountry() {
		return country;
	}
}
