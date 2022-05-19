package vo;

public class CartVo {
	private Long no;
	private Long memberNo;
	private Long bookNo;
	private int count;
	
	public Long getNo() {
		return no;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public int getCount() {
		return count;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", memberNo=" + memberNo + "]";
	}
}
