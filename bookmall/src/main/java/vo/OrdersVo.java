package vo;

public class OrdersVo {
	private Long no;
	private String address;
	private Long memberNo;
	private Long bookNo;
	private Long orderNo;
	private Long price;
	
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getNo() {
		return no;
	}
	public String getAddress() {
		return address;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	
	
}
