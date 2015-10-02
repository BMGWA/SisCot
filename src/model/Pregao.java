package model;

import java.sql.Date;
import java.util.ArrayList;

public class Pregao {
	private ArrayList<Product> products;
	private Date pregaoDate;
	private String managerName;
	
	public Pregao () {
		super();
		
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public Date getPregaoDate() {
		return pregaoDate;
	}

	public void setPregaoDate(Date pregaoDate) {
		this.pregaoDate = pregaoDate;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
}
