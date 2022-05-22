package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<OrdersVo> findAll() throws SQLException{
		List<OrdersVo> result = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnection dc = new DBConnection();
		connection = dc.getConnection();


		String sql = "select  a.no, a.number,b.name,b.email,a.price ,a.address "
				+ "from orders a, member b "
				+ "where a.no = b.no ";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while(rs.next()){
			Long no = rs.getLong(1);
			Long count = rs.getLong(2);
			String memberName = rs.getString(3);
			String memberEmail = rs.getString(4);
			Long price = rs.getLong(5);
			String address = rs.getString(6);


			OrdersVo vo = new OrdersVo();
			vo.setNo(no);
			vo.setCount(count);
			vo.setMemberName(memberName);
			vo.setMemberEmail(memberEmail);
			vo.setPrice(price);
			vo.setAddress(address);

			result.add(vo);
		}
		dc.close(connection, pstmt, rs);

		return result;
	}
	public List<OrdersVo> findOrderBook() throws SQLException{
		List<OrdersVo> result = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnection dc = new DBConnection();
		connection = dc.getConnection();


		String sql = "select  c.no, b.title, c.count, a.price "
				+ "from orders a, book b, order_book c "
				+ "where a.no = c.no "
				+ "and b.no = c.no";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while(rs.next()){
			Long no = rs.getLong(1);
			String title = rs.getString(2);
			Long count = rs.getLong(2);
			Long price = rs.getLong(5);

			OrdersVo vo = new OrdersVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setPrice(price);

			result.add(vo);
		}
		dc.close(connection, pstmt, rs);

		return result;

	}
}
