package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnection;
import vo.OrdersVo;

public class OrdersDao {

	public boolean insert(OrdersVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DBConnection dc = new DBConnection();
		try {
			connection = dc.getConnection();
			
			
			String sql =
				"insert " +
				"into orders " +
				"values(null, ?, ?)";
			
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, vo.getAddress());
			pstmt.setLong(2, vo.getMemberNo());
		
			rs = pstmt.executeQuery();	
		} catch(SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);

		} finally {
			dc.close(connection, pstmt, rs);
		}
		
		result = true;
		return result;		
	}
}
