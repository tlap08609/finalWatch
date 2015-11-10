package shoppingCart.model;

public class OrderItem {
	private int seqno;
	private int productNo;
	private String description;
	private int amount;
	private double unitPrice;

	public OrderItem(int key) {
		seqno = key;
	}

	public OrderItem(int productNo, String description, int amount,
			double unitPrice) {
		super();

		this.productNo = productNo;
		this.description = description;
		this.amount = amount;
		this.unitPrice = unitPrice;
	}

	public OrderItem() {
		super();
	}

	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
