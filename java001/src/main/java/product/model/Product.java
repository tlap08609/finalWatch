package product.model;

import java.sql.Blob;


public class Product {
	private long productNo;
    String productName;
    String productContent;
    double productPrice;
    int productStock;
//    @Column(name = "productPic", unique = false, nullable = false, length = 100000)
    private Blob productPic;
   

	public Product(long key) {
		productNo = key;
	}
	
	public Product(String productName, String productContent, 
			double productPrice, int productStock
			,Blob productPic) {
		super();
		this.productName = productName;
		this.productContent = productContent;
		this.productPrice = productPrice;
		this.productStock = productStock;
		
		this.productPic = productPic;

	}
	
	public Product(long productNo, String productName, 
			String productContent, Double productPrice, int productStock
			,Blob productPic) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productContent = productContent;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productPic = productPic;

	}
	public Product(long productNo, String productName, 
			String productContent, Double productPrice, int productStock
			) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productContent = productContent;
		this.productPrice = productPrice;
		this.productStock = productStock;
		

	}

	public Product() {
		super();
	}

	public long getproductNo() {
		return productNo;
	}
	public void setproductNo(long productNo) {
		this.productNo = productNo;
	}
	public String getproductName() {
		return productName;
	}
	public void setproductName(String productName) {
		this.productName = productName;
	}
	public String getproductContent() {
		return productContent;
	}
	public void setproductContent(String productContent) {
		this.productContent = productContent;
	}
	public Double getproductPrice() {
		return productPrice;
	}

	public void setproductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getproductStock() {
		return productStock;
	}
	public void setproductStock(int productStock) {
		this.productStock = productStock;
	}
	
	public Blob getproductPic() {
		return productPic;
	}
	public void setproductPic(Blob productPic) {
		this.productPic = productPic;
	}
	
	
	
//	private byte[] toByteArray(Blob fromImageBlob) {
//	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//	    try {
//	      return toByteArrayImpl(fromImageBlob, baos);
//	    } catch (Exception e) {
//	    }
//	    return null;
//	  }
//
//
//
//	private byte[] toByteArrayImpl(Blob fromImageBlob, 
//	      ByteArrayOutputStream baos) throws SQLException, IOException {
//	    byte buf[] = new byte[4000];
//	    int dataSize;
//	    InputStream is = fromImageBlob.getBinaryStream(); 
//
//	    try {
//	      while((dataSize = is.read(buf)) != -1) {
//	        baos.write(buf, 0, dataSize);
//	      }    
//	    } finally {
//	      if(is != null) {
//	        is.close();
//	      }
//	    }
//	    return baos.toByteArray();
//	  }

	// bookAccessBean

	
	
}
