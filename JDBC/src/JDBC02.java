import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02 {
	//���� �޼��� �ȿ� ����� ���̱� ������ static �ʿ�
	static final String driver = "oracle.jdbc.OracleDriver";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String id = "scott";
	static final String pw = "tiger";
	//������ �־ ������
	private static void insertData() {
		//����̹� ã��
		//�����ϱ�
		//�����غ�
		//����������
		//����ޱ�
		Connection conn = null;
		PreparedStatement pstmt = null; // �߰��� ���� ����ä�� ���ϰ� ���Ƶδ� ��(��ŷ ����)
		String sql = "INSERT INTO EMP VALUES(?,?,?,?,?,?,?,?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);//driver ���ᰴü ������ - ����
			pstmt = conn.prepareStatement(sql);// �ٷ� ���� ����
			pstmt.setInt(1, 8756);//EMPNO
			pstmt.setString(2, "JJANG022");//ENAME
			pstmt.setString(3, "SAM");//JOB
			pstmt.setInt(4, 1234);//MGR
			pstmt.setString(5, "2022-01-20");//HIREDATE
			pstmt.setInt(6, 2450);//SAL
			pstmt.setInt(7, 0);//COMM
			pstmt.setInt(8, 40);//DEPTNO
			int result = pstmt.executeUpdate();// � �࿡ ������ ���ƴ��� (������Ʈ �� ������ ���� ���´�) 
			System.out.println(result); // 1 ��� 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	//�������� �̷��� ���Ḧ ���־�� �Ѵ� (����)		
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	}
	//������ �޾ƿ���
	private static void getDate() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);//class�� �̸����� ã����(driver ã��)
			conn = DriverManager.getConnection(url,id,pw);//url,id,pw(driver ���ᰴü ������ - ����)
			System.out.println("db����");
			stmt = conn.createStatement();//����(sql) �غ�
			rs = stmt.executeQuery("SELECT * FROM EMP");//����(sql) ������ = ��� ������ �޾ƿ´�(=ResultSet)
			if(rs!=null) {//������� ������
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
	public static void main(String[] args) {
		getDate(); // Ȯ��
		//insertData(); // �߰�
	}
}
