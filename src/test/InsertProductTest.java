package test;

import java.sql.Connection;

import org.junit.Test;

import controller.InsertProduct;
import dao.ConnectionFactory;
import dao.ProductDAO;
import junit.framework.TestCase;
import model.Product;

public class InsertProductTest extends TestCase {
	Connection connection = new ConnectionFactory().getConnection();
	Product product = new Product();
	ProductDAO productDao = new ProductDAO();
	InsertProduct insertProduct = new InsertProduct();
	
	@Test
	public void testInsertProduct() {
		product.setProductName("Vassoura");
		product.setProductPrice(2.57);
		
		assertTrue(productDao.insertProduct(product));
	}
	
	@Test
	public void testInsertProductWithConstructor() {
		Product newProduct = new Product("Farinha", 3.00, null);
		
		assertTrue(productDao.insertProduct(newProduct));
	}
}
