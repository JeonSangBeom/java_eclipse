import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC01 {
	static final String driver = "oracle.jdbc.OracleDriver";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String id = "TIS001";
	static final String pw = "1234";
	//하나만 출력하는 곳
	private static void selectOne() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("보고싶은 아이디를 입력하시오");
		int _id = scanner.nextInt();
		try {
			Class.forName(driver);//class를 이름으로 찾을때(driver 찾기)
			conn = DriverManager.getConnection(url,id,pw);//url,id,pw(driver 연결객체 얻어오기 - 연결)
			System.out.println("db연결");
			String sql ="SELECT * FROM MEMBER WHERE ID = ? ORDER BY ID DESC";
			pstmt = conn.prepareStatement(sql);//질문(sql) 준비
			pstmt.setInt(1, _id);
			rs = pstmt.executeQuery();//질문(sql) 날리기 = 결과 값으로 받아온다(=ResultSet)
			if(rs!=null) {//결과값이 있으면
				System.out.println(rs+"질문 날리고 답변 받기 성공");
			}
			//가져오는 것은 다섯개이기 때문에 다섯개 설정
			//sql에서 입력한 값은 commit을 해야 제대로 넘어 온다
			while(rs.next()) {//다음께 있으면 반복
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String email = rs.getString("EMAIL");
				String hp = rs.getString("HP");
				String regDate = rs.getString("REGDATE");
				System.out.println("ID : "+id +" "+name+" " +email + " " +hp+ " " +regDate);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("db연결 에러");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	//마지막은 이렇게 종료를 해주어야 한다 (역순)		
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
		}
	}
	
	//수정하는 곳
	private static void updateDate() {
		//수정할 id를 입력 받아
		//이름을 바꾸기
		//email을 바꾸기
		//hp를 바꾸기
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("변경할 아이디를 입력하시오");
		int _id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("이름을 바꾸세요");
		String _name = scanner.nextLine();
		System.out.println("이메일 바꾸세요");
		String _email = scanner.nextLine();
		System.out.println("전화번호 바꾸세요");
		String _hp = scanner.nextLine();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);//driver 연결객체 얻어오기 - 연결
			String sql = "UPDATE MEMBER SET NAME = ?, EMAIL = ?, HP  =? WHERE ID = ?";
			//PreparedStatement는 자동으로 commit도 해준다 / 삭제 후 sql에서 확인시 삭제가 된 것을 볼 수 있음
			pstmt = conn.prepareStatement(sql);// 바로 질문 들어가게
			//순서 sql과 맞아야 한다
			pstmt.setInt(4, _id);
			pstmt.setString(1, _name);
			pstmt.setString(2, _email);
			pstmt.setString(3, _hp);
			int result = pstmt.executeUpdate();// 몇개 행에 영향을 미쳤느냐 (업데이트 한 갯수로 답을 얻어온다)			
			if(result>0) {
				System.out.println(_id+" 님의 정보가 바뀌었습니다"); // 1 출력	
			}			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	//마지막은 이렇게 종료를 해주어야 한다 (역순)		
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	//삭제하는 곳
	private static void deleteData() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("삭제할 아이디를 입력하시오");
		int _id = scanner.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);//driver 연결객체 얻어오기 - 연결
			String sql = "DELETE FROM MEMBER\r\n"
					+ "WHERE ID = ?";
			//PreparedStatement는 자동으로 commit도 해준다 / 삭제 후 sql에서 확인시 삭제가 된 것을 볼 수 있음
			pstmt = conn.prepareStatement(sql);// 바로 질문 들어가게
			pstmt.setInt(1, _id);
			int result = pstmt.executeUpdate();// 몇개 행에 영향을 미쳤느냐 (업데이트 한 갯수로 답을 얻어온다)			
			if(result>0) {
				System.out.println(_id+" 삭제되었습니다."); // 1 출력	
			}			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	//마지막은 이렇게 종료를 해주어야 한다 (역순)		
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	//데이터 접속 및 값 얻어오는 곳
	private static void getData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);//class를 이름으로 찾을때(driver 찾기)
			conn = DriverManager.getConnection(url,id,pw);//url,id,pw(driver 연결객체 얻어오기 - 연결)
			System.out.println("db연결");
			String sql ="SELECT * FROM MEMBER ORDER BY ID DESC";
			stmt = conn.createStatement();//질문(sql) 준비
			rs = stmt.executeQuery(sql);//질문(sql) 날리기 = 결과 값으로 받아온다(=ResultSet)
			if(rs!=null) {//결과값이 있으면
				System.out.println(rs+"질문 날리고 답변 받기 성공");
			}
			//가져오는 것은 다섯개이기 때문에 다섯개 설정
			//sql에서 입력한 값은 commit을 해야 제대로 넘어 온다
			while(rs.next()) {//다음께 있으면 반복
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String email = rs.getString("EMAIL");
				String hp = rs.getString("HP");
				String regDate = rs.getString("REGDATE");
				System.out.println("ID : "+id +" "+name+" " +email + " " +hp+ " " +regDate);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("db연결 에러");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	//마지막은 이렇게 종료를 해주어야 한다 (역순)		
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
		}
	}
	
	// 데이터 입력 추가 하는 곳
	private static void insertData() {
		Connection conn = null;
		PreparedStatement pstmt = null; // 중간에 질문 가로채지 못하게 막아두는 법(해킹 방지)	
		//JSP에서 넘어온 값이 DB로 값을 넘겨주게 될 것이다
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름을 입력하시오");
		String _name = scanner.nextLine();
		System.out.println("이메일을 입력하시오");
		String _email = scanner.nextLine();
		System.out.println("전화번호을 입력하시오");
		String _hp = scanner.nextLine();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);//driver 연결객체 얻어오기 - 연결
			String sql = "INSERT INTO MEMBER VALUES(SEQ_MEMBER.NEXTVAL,?,?,?,SYSDATE)";
			//SEQ_MEMBER.NEXTVAL - 시퀀스를 이용하여 자동 증가를 사용하였기 때문에 이제 1의 자리에 있을 필요가 없다
			pstmt = conn.prepareStatement(sql);// 바로 질문 들어가게
			pstmt.setString(1, _name);//name
			pstmt.setString(2, _email);//mail
			pstmt.setString(3, _hp);//hp			
			int result = pstmt.executeUpdate();// 몇개 행에 영향을 미쳤느냐 (업데이트 한 갯수로 답을 얻어온다)
			if(result>0) {
				System.out.println(result +"이 입력되었습니다."); // 1 출력	
			}			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	//마지막은 이렇게 종료를 해주어야 한다 (역순)		
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
	public static void main(String[] args) {
		//getData();
		//insertData();
		//deleteData();
		//updateDate();
		//selectOne();
		System.out.println("시작");
		Scanner scanner = new Scanner(System.in);
	    boolean off = false;
	    while(true) {
	    	System.out.println("0:종료, 1:모든 맴버 정보 출력, 2:원하는 ID 한명 출력, 3:삭제, 4:입력, 5:수정");
		    int sel = scanner.nextInt();
	    	switch(sel) {
	    	case 1:
	    		getData();
	    		break;
	    	case 2:
	    		selectOne();
	    		break;
	    	case 3:
	    		deleteData();
	    		break;
	    	case 4:
	    		insertData();
	    		break;
	    	case 5:
	    		updateDate();
	    		break;
	    	case 0:
	    		off = true;
	    		break;
	    	}
	    	if(off) System.out.println(off+"종료되었습니다");break;
	    }
	}	
}
