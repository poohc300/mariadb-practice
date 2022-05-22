package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBConnection;
import vo.CategoryVo;

public class CategoryDao {

	public boolean insert(CategoryVo vo) {
		
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DBConnection dc = new DBConnection();
	
		try {
			connection = dc.getConnection();
			
		
			String sql =
				"insert " +
				"into category " +
				"values(null, ?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
		
			rs = pstmt.executeQuery();
		
		} catch(SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);	
		} finally {
		dc.close(connection, pstmt, rs);
		}
		
		result = true;
		return result;		
	}

	public List<CategoryVo> findAll() throws SQLException{
		List<CategoryVo> result = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnection dc = new DBConnection();
		connection = dc.getConnection();


		String sql =  "select * from category ";

		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while(rs.next()) {
			Long no = rs.getLong(1);
			String name = rs.getString(2);

			CategoryVo vo = new CategoryVo();
			vo.setNo(no);
			vo.setName(name);

			result.add(vo);
		}

		dc.close(connection, pstmt, rs);

		return result;

	}
}
