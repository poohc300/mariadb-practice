package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnection;
import vo.MemberVo;

public class MemberDao {

	public boolean insert(MemberVo vo) throws SQLException {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DBConnection dc = new DBConnection();
		try {
			connection = dc.getConnection();
			
			
			String sql =
				"insert " +
				"into member " +
				"values(null, ?, ?, ?, ?)";
			
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhoneNumber());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPassword());

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
