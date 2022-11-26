import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC01 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");//class를 이름으로 찾을때(driver 찾기)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");//url,id,pw(driver 연결객체 얻어오기 - 연결)
			System.out.println("db연결");
			stmt = conn.createStatement();//질문(sql) 준비
			rs = stmt.executeQuery("SELECT * FROM EMP");//질문(sql) 날리기 = 결과 값으로 받아온다(=ResultSet)
			if(rs!=null) {//결과값이 이
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
}
