package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.BookDao;
import dao.CartDao;
import dao.CategoryDao;
import dao.MemberDao;
import dao.OrdersDao;
import util.DBConnection;
import vo.BookVo;
import vo.CartVo;
import vo.CategoryVo;
import vo.MemberVo;
import vo.OrdersVo;

public class BookMall {

	public static void main(String[] args) throws SQLException {
		
		categoryInsert();
		bookInsert();
		memberInsert();
		cartInsert();
		ordersInsert();

	}
	
	public static void categoryInsert() {
		CategoryDao dao = new CategoryDao();
		CategoryVo vo = new CategoryVo();
		
		vo.setName("과학");
		dao.insert(vo);
		vo.setName("IT");
		dao.insert(vo);
		vo.setName("문학");
		dao.insert(vo);
	}
	
	public static void memberInsert() throws SQLException {
		
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		
		vo.setName("김잼민");
		vo.setPhoneNumber("010-1111-2222");
		vo.setEmail("jaemin@hanmail.net");
		vo.setPassword("1234");
		dao.insert(vo);
		
		vo.setName("제레미");
		vo.setPhoneNumber("010-3333-4444");
		vo.setEmail("jerem@lycos.co.kr");
		vo.setPassword("1234");
		dao.insert(vo);
	}
	
	public static void bookInsert() {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		
		vo.setName("이것이 MariaDB다");
		vo.setPrice((long) 1000);
		vo.setCategoryNo((long) 2);
		dao.insert(vo);
		
		vo.setName("러닝 React.JS");
		vo.setPrice((long) 2000);
		vo.setCategoryNo((long) 2);
		dao.insert(vo);
		
		vo.setName("코스모스");
		vo.setPrice((long) 1000);
		vo.setCategoryNo((long) 1);
		dao.insert(vo);
		
		vo.setName("수레바퀴아래서");
		vo.setPrice((long) 3000);
		vo.setCategoryNo((long) 3);
		dao.insert(vo);
	}
	
	public static void cartInsert() {
		CartDao dao = new CartDao();
		CartVo vo = new CartVo();
		
		vo.setMemberNo((long) 1);
		vo.setBookNo((long) 1);
		vo.setCount(2);
		dao.insert(vo);
		
		vo.setMemberNo((long) 1);
		vo.setBookNo((long) 2);
		vo.setCount(1);
		dao.insert(vo);
		
		vo.setMemberNo((long) 2);
		vo.setBookNo((long) 2);
		vo.setCount(3);
		dao.insert(vo);
	}
	
	public static void ordersInsert() {
		
		OrdersDao dao = new OrdersDao();
		OrdersVo vo = new OrdersVo();
		
		vo.setAddress("경기도 파주시 파평면 마산2리");
		vo.setMemberNo((long) 2);
		vo.setBookNo((long) 1);
		vo.setOrderNo((long) 1);
		dao.insert(vo);
		ordersBookInsert(vo);
		
		
	}
	
	public static boolean ordersBookInsert(OrdersVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DBConnection dc = new DBConnection();
		try {
			connection = dc.getConnection();
			
			
			String sql =
				"insert " +
				"into orders_book " +
				"values (null, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getBookNo());
			pstmt.setLong(2, vo.getMemberNo());
			
			rs = pstmt.executeQuery();
			
		} catch(SQLException e) {
			System.out.println("드라이버 로딩 실패: "+e);
		} finally {
			dc.close(connection, pstmt, rs);
		}
		
		result = true;
		return result;		
	}
	
}
