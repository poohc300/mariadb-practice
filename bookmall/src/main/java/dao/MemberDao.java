package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<MemberVo> findAll() throws SQLException {
		List<MemberVo> result = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnection dc = new DBConnection();
		connection = dc.getConnection();


		String sql =  "select * from member ";

		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while(rs.next()) {
			Long no = rs.getLong(1);
			String name = rs.getString(2);
			String phoneNumber = rs.getString(3);
			String email = rs.getString(4);
			String password = rs.getString(5);

			MemberVo vo = new MemberVo();
			vo.setNo(no);
			vo.setName(name);
			vo.setPhoneNumber(phoneNumber);
			vo.setEmail(email);
			vo.setPassword(password);

			result.add(vo);
		}

		dc.close(connection, pstmt, rs);

		return result;

	}
}
