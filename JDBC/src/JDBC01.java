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
			Class.forName("oracle.jdbc.OracleDriver");//class�� �̸����� ã����(driver ã��)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");//url,id,pw(driver ���ᰴü ������ - ����)
			System.out.println("db����");
			stmt = conn.createStatement();//����(sql) �غ�
			rs = stmt.executeQuery("SELECT * FROM EMP");//����(sql) ������ = ��� ������ �޾ƿ´�(=ResultSet)
			if(rs!=null) {//������� ��
				System.out.println("���� ������ �亯 �ޱ� ����");
			}
			while(rs.next()) {
				String empNo = rs.getString("EMPNO");
				String ename = rs.getString("ENAME");
				String job = rs.getString("JOB");
				System.out.println("empNo : "+empNo +" "+ename+" " +job);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("db���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	//�������� �̷��� ���Ḧ ���־�� �Ѵ� (����)		
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
