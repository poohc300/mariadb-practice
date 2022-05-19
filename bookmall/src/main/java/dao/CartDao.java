package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnection;
import vo.CartVo;

public class CartDao {

	public boolean insert(CartVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DBConnection dc = new DBConnection();
		
		try {
			connection = dc.getConnection();
			
		
			String sql =
				"insert " +
				"into cart " +
				"values(null, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getMemberNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getCount());
			
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
