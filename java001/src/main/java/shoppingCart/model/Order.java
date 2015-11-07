package shoppingCart.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import product.model.OrderItemBean;

public class Order {
	int 	orderNo;
	String 	userId;
	double	totalAmount;
	String	shippingAddress; 
	String  bno;
	String  invoiceTitle;
	Date  orderDate;
	Date  shippingDate;
	String	cancelTag;
	List<OrderItem> items = new ArrayList<OrderItem>();
	
	
	
	
	public Order() {
		super();
	}
	public Order(String userId, double totalAmount, String shippingAddress,
			String bno, String invoiceTitle, Date orderDate, Date shippingDate,
			 List<OrderItem> items) {
		super();
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.shippingAddress = shippingAddress;
		this.bno = bno;
		invoiceTitle = invoiceTitle;
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.items = items;
	}
	
	
	
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		invoiceTitle = invoiceTitle;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getCancelTag() {
		return cancelTag;
	}
	public void setCancelTag(String cancelTag) {
		this.cancelTag = cancelTag;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	

	

	
	
	
	
	
	
	
	

	

    
}
