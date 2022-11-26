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
	//�ϳ��� ����ϴ� ��
	private static void selectOne() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("������� ���̵� �Է��Ͻÿ�");
		int _id = scanner.nextInt();
		try {
			Class.forName(driver);//class�� �̸����� ã����(driver ã��)
			conn = DriverManager.getConnection(url,id,pw);//url,id,pw(driver ���ᰴü ������ - ����)
			System.out.println("db����");
			String sql ="SELECT * FROM MEMBER WHERE ID = ? ORDER BY ID DESC";
			pstmt = conn.prepareStatement(sql);//����(sql) �غ�
			pstmt.setInt(1, _id);
			rs = pstmt.executeQuery();//����(sql) ������ = ��� ������ �޾ƿ´�(=ResultSet)
			if(rs!=null) {//������� ������
				System.out.println(rs+"���� ������ �亯 �ޱ� ����");
			}
			//�������� ���� �ټ����̱� ������ �ټ��� ����
			//sql���� �Է��� ���� commit�� �ؾ� ����� �Ѿ� �´�
			while(rs.next()) {//������ ������ �ݺ�
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String email = rs.getString("EMAIL");
				String hp = rs.getString("HP");
				String regDate = rs.getString("REGDATE");
				System.out.println("ID : "+id +" "+name+" " +email + " " +hp+ " " +regDate);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("db���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	//�������� �̷��� ���Ḧ ���־�� �Ѵ� (����)		
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
		}
	}
	
	//�����ϴ� ��
	private static void updateDate() {
		//������ id�� �Է� �޾�
		//�̸��� �ٲٱ�
		//email�� �ٲٱ�
		//hp�� �ٲٱ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ ���̵� �Է��Ͻÿ�");
		int _id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("�̸��� �ٲټ���");
		String _name = scanner.nextLine();
		System.out.println("�̸��� �ٲټ���");
		String _email = scanner.nextLine();
		System.out.println("��ȭ��ȣ �ٲټ���");
		String _hp = scanner.nextLine();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);//driver ���ᰴü ������ - ����
			String sql = "UPDATE MEMBER SET NAME = ?, EMAIL = ?, HP  =? WHERE ID = ?";
			//PreparedStatement�� �ڵ����� commit�� ���ش� / ���� �� sql���� Ȯ�ν� ������ �� ���� �� �� ����
			pstmt = conn.prepareStatement(sql);// �ٷ� ���� ����
			//���� sql�� �¾ƾ� �Ѵ�
			pstmt.setInt(4, _id);
			pstmt.setString(1, _name);
			pstmt.setString(2, _email);
			pstmt.setString(3, _hp);
			int result = pstmt.executeUpdate();// � �࿡ ������ ���ƴ��� (������Ʈ �� ������ ���� ���´�)			
			if(result>0) {
				System.out.println(_id+" ���� ������ �ٲ�����ϴ�"); // 1 ���	
			}			 
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
	
	//�����ϴ� ��
	private static void deleteData() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ ���̵� �Է��Ͻÿ�");
		int _id = scanner.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);//driver ���ᰴü ������ - ����
			String sql = "DELETE FROM MEMBER\r\n"
					+ "WHERE ID = ?";
			//PreparedStatement�� �ڵ����� commit�� ���ش� / ���� �� sql���� Ȯ�ν� ������ �� ���� �� �� ����
			pstmt = conn.prepareStatement(sql);// �ٷ� ���� ����
			pstmt.setInt(1, _id);
			int result = pstmt.executeUpdate();// � �࿡ ������ ���ƴ��� (������Ʈ �� ������ ���� ���´�)			
			if(result>0) {
				System.out.println(_id+" �����Ǿ����ϴ�."); // 1 ���	
			}			 
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
	
	//������ ���� �� �� ������ ��
	private static void getData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);//class�� �̸����� ã����(driver ã��)
			conn = DriverManager.getConnection(url,id,pw);//url,id,pw(driver ���ᰴü ������ - ����)
			System.out.println("db����");
			String sql ="SELECT * FROM MEMBER ORDER BY ID DESC";
			stmt = conn.createStatement();//����(sql) �غ�
			rs = stmt.executeQuery(sql);//����(sql) ������ = ��� ������ �޾ƿ´�(=ResultSet)
			if(rs!=null) {//������� ������
				System.out.println(rs+"���� ������ �亯 �ޱ� ����");
			}
			//�������� ���� �ټ����̱� ������ �ټ��� ����
			//sql���� �Է��� ���� commit�� �ؾ� ����� �Ѿ� �´�
			while(rs.next()) {//������ ������ �ݺ�
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String email = rs.getString("EMAIL");
				String hp = rs.getString("HP");
				String regDate = rs.getString("REGDATE");
				System.out.println("ID : "+id +" "+name+" " +email + " " +hp+ " " +regDate);
				
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
	
	// ������ �Է� �߰� �ϴ� ��
	private static void insertData() {
		Connection conn = null;
		PreparedStatement pstmt = null; // �߰��� ���� ����ä�� ���ϰ� ���Ƶδ� ��(��ŷ ����)	
		//JSP���� �Ѿ�� ���� DB�� ���� �Ѱ��ְ� �� ���̴�
		Scanner scanner = new Scanner(System.in);
		System.out.println("�̸��� �Է��Ͻÿ�");
		String _name = scanner.nextLine();
		System.out.println("�̸����� �Է��Ͻÿ�");
		String _email = scanner.nextLine();
		System.out.println("��ȭ��ȣ�� �Է��Ͻÿ�");
		String _hp = scanner.nextLine();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);//driver ���ᰴü ������ - ����
			String sql = "INSERT INTO MEMBER VALUES(SEQ_MEMBER.NEXTVAL,?,?,?,SYSDATE)";
			//SEQ_MEMBER.NEXTVAL - �������� �̿��Ͽ� �ڵ� ������ ����Ͽ��� ������ ���� 1�� �ڸ��� ���� �ʿ䰡 ����
			pstmt = conn.prepareStatement(sql);// �ٷ� ���� ����
			pstmt.setString(1, _name);//name
			pstmt.setString(2, _email);//mail
			pstmt.setString(3, _hp);//hp			
			int result = pstmt.executeUpdate();// � �࿡ ������ ���ƴ��� (������Ʈ �� ������ ���� ���´�)
			if(result>0) {
				System.out.println(result +"�� �ԷµǾ����ϴ�."); // 1 ���	
			}			 
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
	public static void main(String[] args) {
		//getData();
		//insertData();
		//deleteData();
		//updateDate();
		//selectOne();
		System.out.println("����");
		Scanner scanner = new Scanner(System.in);
	    boolean off = false;
	    while(true) {
	    	System.out.println("0:����, 1:��� �ɹ� ���� ���, 2:���ϴ� ID �Ѹ� ���, 3:����, 4:�Է�, 5:����");
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
	    	if(off) System.out.println(off+"����Ǿ����ϴ�");break;
	    }
	}	
}
