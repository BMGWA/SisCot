package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

import dao.ConnectionFactory;
import dao.QuotationDAO;
import junit.framework.TestCase;
import model.Manager;
import model.Product;
import model.Quotation;

public class QuotationDAOTest extends TestCase {
	
	Connection connection = new ConnectionFactory().getConnection();
	Quotation quotation = new Quotation();
	QuotationDAO quotationDao = new QuotationDAO();
	Manager manager = new Manager();;
	Date quotationDate = new Date(0);
	Product product = new Product();
	ArrayList<Product> products = new ArrayList<Product>();
	ArrayList<Quotation> quotations = new ArrayList<Quotation>();
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet rs;
	int i;
	
	@Test
	public void testInsertQuotation() throws SQLException {
		product.setProductName("ProdutoPregao");
		product.setProductDescription("Produto do Pregrao");
		
		products.add(product);
		
		quotation.setManagerName("Joao");
		quotation.setQuotationDate(quotationDate);
		
		assertTrue(quotationDao.includeQuotation(quotation));
	}
	
	@Test
	public void testInsertQuotationChekingValues() throws SQLException {
		product.setProductName("TestPregrao");
		product.setProductDescription("pregao teste");
		
		products.add(product);
		
		quotation.setManagerName("Maria");
		quotation.setQuotationDate(quotationDate);
		
		quotationDao.includeQuotation(quotation);
		
		String sql = "SELECT managerName FROM Quotation WHERE managerName = 'Maria'";
		
		statement = this.connection.prepareStatement(sql);
		rs = statement.executeQuery(sql);
		rs.next();
		String result = rs.getString("managerName");
		
		assertEquals("Maria", result);
	}
	
	@Test
	public void testListQuotations() throws SQLException {
		quotations = quotationDao.listQuotation();
		
		assertEquals(false, quotations.isEmpty());
	}
	
	@Test
	public void testListQuotationsComparingValues() throws SQLException {
		quotations = quotationDao.listQuotation();
		
		assertNotSame("Joao", quotations.get(0).getManagerName());
	}
	
	@Test
	public void testDeleteQuotation() throws SQLException {
		quotation.setManagerName("Levino");
		quotation.setQuotationDate(quotationDate);
		
		product.setProductName("Macbook");
		product.setProductDescription("Macbook pro 13");
		
		products.add(product);
		
		quotation.setProducts(products);
		
		quotationDao.includeQuotation(quotation);
		
		assertTrue(quotationDao.deleteQuotation(5));
	}
	
	@Test
	public void testDeleteQuotationSearchingForTheQuotation() throws SQLException {
		quotation.setManagerName("Jonathan");
		quotation.setQuotationDate(quotationDate);
		
		product.setProductName("Galaxy");
		product.setProductDescription("S3");
		
		products.add(product);
		
		quotation.setProducts(products);
		
		quotationDao.includeQuotation(quotation);
		quotationDao.deleteQuotation(4);
		
		quotations = quotationDao.listQuotation();
		boolean quotationExists = false;
		
		for(i = 0; i < quotations.size(); i++) {
			quotationExists = quotations.get(i).getManagerName().equals("Jonathan");
		}
		
		assertTrue(quotationExists);
	}
	
	@Test
	public void testUpdateQuotation() throws SQLException {
		quotation.setManagerName("Amanda");
		quotation.setQuotationDate(quotationDate);
		
		product.setProductName("Batom");
		product.setProductDescription("vermelho");		
		products.add(product);
		
		quotation.setProducts(products);
		
		quotationDao.includeQuotation(quotation);
		
		products.clear();
		
		Quotation quotation2 = new Quotation();
		quotation2.setManagerName("Anne");
		quotation2.setQuotationDate(quotationDate);
		product.setProductName("Batom");
		product.setProductDescription("vermelho");		
		products.add(product);
		quotation2.setProducts(products);
		
		quotationDao.updateQuotation(6, quotation2);
		
		quotations = quotationDao.listQuotation();

		Quotation quotation3 = new Quotation();
		
		for(i = 0; i < quotations.size(); i++) {
			if(quotations.get(i).getManagerName().equals("Anne")) {
				quotation3 = quotations.get(i);
			}
		}
		
		assertNotSame(quotation, quotation3);
	}

}
