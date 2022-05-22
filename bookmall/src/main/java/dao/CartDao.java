package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<CartVo> findAll() throws SQLException{
		List<CartVo> result = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnection dc = new DBConnection();
		connection = dc.getConnection();


		String sql =
				"   select c.name, b.title, a.stock" +
						" from cart a, book b, member c" +
						" where a.book_no = b.no" +
						" and a.member_no = c.no";

		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while(rs.next()) {
			String memberName = rs.getString(1);
			String bookTitle = rs.getString(2);
			int count = rs.getInt(3);

			CartVo vo = new CartVo();
			vo.setBookTitle(bookTitle);
			vo.setMemberName(memberName);
			vo.setCount(count);

			result.add(vo);
		}

		dc.close(connection, pstmt, rs);

		return result;

	}
}
