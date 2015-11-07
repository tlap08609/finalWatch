package product.model;

//本類別封裝單筆訂單資料tim
public class OrderItemBean {

	int qty = 0;
	int productID = 0;
	double price = 0;
	int productStock = 0;
	String productName;
	String productContent;

	public OrderItemBean(int productID, int qty, double price,
			String productName, String productContent, int productStock) {
		this.productID = productID;
		this.qty = qty;
		this.price = price;
		this.productName = productName;
		this.productContent = productContent;
		this.productStock = productStock;

	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	// public String getTitle() {
	// return title;
	// }
	// public void setTitle(String title) {
	// this.title = title;
	// }
	// public String getAuthor() {
	// return author;
	// }
	// public void setAuthor(String author) {
	// this.author = author;
	// }
	// public String getCompanyName() {
	// return companyName;
	// }
	// public void setCompanyName(String companyName) {
	// this.companyName = companyName;
	// }
	//
	// public OrderItemBean() {
	// }
	// public int getQty() {
	// return qty;
	// }
	// public void setQty(int qty) {
	// this.qty = qty;
	// }
	// public int getBookID() {
	// return bookID;
	// }
	// public void setBookID(int bookID) {
	// this.bookID = bookID;
	// }
	// public double getPrice() {
	// return price;
	// }
	// public void setPrice(double price) {
	// this.price = price;
	// }
	// public double getDiscount() {
	// return discount;
	// }
	// public void setDiscount(double discount) {
	// this.discount = discount;
	// }
}