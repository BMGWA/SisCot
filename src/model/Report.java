package model;

import java.util.ArrayList;

public abstract class Report {

	private ArrayList<Product> products;
	private Quotation quotation;
	private double totalPrice;
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	public Quotation getQuotation() {
		return quotation;
	}
	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public abstract ArrayList<ArrayList> showProducts();
}
