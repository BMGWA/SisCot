package model;

public class Product {
	private int productId;
	private String productName;
	private double productPrice;
	private Provider productProvider;
	private String productDescription;
	
	public Product() {
		
	}

	public Product(int productId, String productName, double productPrice, Provider productProvider,
			String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productProvider = productProvider;
		this.productDescription = productDescription;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Provider getProductProvider() {
		return productProvider;
	}

	public void setProductProvider(Provider productProvider) {
		this.productProvider = productProvider;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
}
