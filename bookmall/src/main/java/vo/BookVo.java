package vo;

public class BookVo {
	private Long no;
	private String name;
	private Long price;
	private Long categoryNo;
	private String categoryName;
	
	public Long getNo() {
		return no;
	}
	
	public void setNo(Long no2) {
		this.no = no2;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getPrice() {
		return price;
	}
	
	public void setPrice(Long price) {
		this.price = price;
	}
	
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", name=" + name + "]";
	}

}
