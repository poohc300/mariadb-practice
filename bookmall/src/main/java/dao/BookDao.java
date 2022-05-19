package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.BookVo;
import util.DBConnection;

public class BookDao {
	
	public boolean insert(BookVo vo) {
		
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DBConnection dc = new DBConnection();
		
		try {
			connection = dc.getConnection();
		
			String sql =
				"insert " +
				"into book " +
				"values(null, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
	
			pstmt.setString(1, vo.getName());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategoryNo());
			
			rs = pstmt.executeQuery();

		}	
		catch(SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
			
		} finally {
			dc.close(connection, pstmt, rs);
		}
		
		result = true;
		return result;		
		
	}

	public List<BookVo> findAll() throws SQLException{
		List<BookVo> result = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DBConnection dc = new DBConnection();
		connection = dc.getConnection();
	

		String sql =
			"   select a.no, a.name, a.price, b.name" +
			"     from book a, category b" +
			"    where a.no = b.no" +
			" order by no asc";
		
		pstmt = connection.prepareStatement(sql);			
		rs = pstmt.executeQuery();
			
		while(rs.next()) {
			BookVo vo = new BookVo();
			
			vo.setNo(rs.getLong(1)); 
			vo.setName(rs.getString(2)); 
			vo.setPrice(rs.getLong(3)); 
			vo.setCategoryName(rs.getString(4)); 
			
			result.add(vo);
			}
		
		dc.close(connection, pstmt, rs);

		return result;
		
	}
	
	
}
