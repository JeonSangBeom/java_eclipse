import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02 {
	//메인 메서드 안에 사용할 것이기 때문에 static 필요
	static final String driver = "oracle.jdbc.OracleDriver";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String id = "scott";
	static final String pw = "tiger";
	//데이터 넣어서 보내기
	private static void insertData() {
		//드라이버 찾기
		//연결하기
		//질문준비
		//질문날리기
		//결과받기
		Connection conn = null;
		PreparedStatement pstmt = null; // 중간에 질문 가로채지 못하게 막아두는 법(해킹 방지)
		String sql = "INSERT INTO EMP VALUES(?,?,?,?,?,?,?,?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);//driver 연결객체 얻어오기 - 연결
			pstmt = conn.prepareStatement(sql);// 바로 질문 들어가게
			pstmt.setInt(1, 8756);//EMPNO
			pstmt.setString(2, "JJANG022");//ENAME
			pstmt.setString(3, "SAM");//JOB
			pstmt.setInt(4, 1234);//MGR
			pstmt.setString(5, "2022-01-20");//HIREDATE
			pstmt.setInt(6, 2450);//SAL
			pstmt.setInt(7, 0);//COMM
			pstmt.setInt(8, 40);//DEPTNO
			int result = pstmt.executeUpdate();// 몇개 행에 영향을 미쳤느냐 (업데이트 한 갯수로 답을 얻어온다) 
			System.out.println(result); // 1 출력 
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
	//데이터 받아오기
	private static void getDate() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);//class를 이름으로 찾을때(driver 찾기)
			conn = DriverManager.getConnection(url,id,pw);//url,id,pw(driver 연결객체 얻어오기 - 연결)
			System.out.println("db연결");
			stmt = conn.createStatement();//질문(sql) 준비
			rs = stmt.executeQuery("SELECT * FROM EMP");//질문(sql) 날리기 = 결과 값으로 받아온다(=ResultSet)
			if(rs!=null) {//결과값이 있으면
				System.out.println("질문 날리고 답변 받기 성공");
			}
			while(rs.next()) {
				String empNo = rs.getString("EMPNO");
				String ename = rs.getString("ENAME");
				String job = rs.getString("JOB");
				System.out.println("empNo : "+empNo +" "+ename+" " +job);
				
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
	public static void main(String[] args) {
		getDate(); // 확인
		//insertData(); // 추가
	}
}
