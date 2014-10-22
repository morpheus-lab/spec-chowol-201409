package reflection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(dbUrl, "scott", "tiger");
		
		String sql = "SELECT * FROM board";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(String.format("[%d] %s", rs.getLong("bno"), rs.getString("subject")));
		}
		rs.close();
		conn.close();
		
	}
	
}
