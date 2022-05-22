package vo;

public class CartVo {
	private Long no;
	private Long memberNo;
	private Long bookNo;
	private int count;
	private Long price;
	private String bookTitle;
	private String memberName;

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public CartVo() {
	}

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
