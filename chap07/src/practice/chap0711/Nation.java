package practice.chap0711;

public class Nation {
	//�Ӽ� �ΰ� ����� capital, country String
	//������ �����
	//�Ӽ��� ���� �� ���� �ְ�	
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
