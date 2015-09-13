/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import controller.IncludeProduct;
import dao.DBConfigure;
import dao.DBConnect;

/**
 * @author tiago
 *
 */
public class ProductTeste {
	
	@Test
	public void testIfReturnsTrueWithCorrectNameAndDescripriton() {
		IncludeProduct includeProduct = new IncludeProduct();
		String nameProduct = "Orange";
		String descriptionProduct = "Is a fruit";
		
		boolean aceptedNameAndDescription= false;
		aceptedNameAndDescription = includeProduct.includeProduct(nameProduct, descriptionProduct);
		
		assertEquals(true, aceptedNameAndDescription);
	}
	
	@Test
	public void testIfReturnsFalseWithIncorrectName() {
		IncludeProduct includeProduct = new IncludeProduct();
		String nameProduct = null;
		String descriptionProduct = "Is a fruit";
		
		boolean aceptedNameAndDescription= true;
		try{
			aceptedNameAndDescription = includeProduct.includeProduct(nameProduct, descriptionProduct);
		}
		catch(Exception e){
			aceptedNameAndDescription = false;
		}
		
		
		assertEquals(false, aceptedNameAndDescription);
	}
	
	@Test
	public void testIfReturnsFalseWithIncorrectDescription() {
		IncludeProduct includeProduct = new IncludeProduct();
		String nameProduct = "Orange";
		String descriptionProduct = null;
		
		boolean aceptedNameAndDescription= true;
		try{
			aceptedNameAndDescription = includeProduct.includeProduct(nameProduct, descriptionProduct);
		}
		catch(Exception e){
			aceptedNameAndDescription = false;
		}
		
		
		assertEquals(false, aceptedNameAndDescription);
	}
	
	
	@Test
	public void testIfReturnsFalseWithIncorrectDescriptionAndName() {
		IncludeProduct includeProduct = new IncludeProduct();
		String nameProduct = null;
		String descriptionProduct = null;
		
		boolean aceptedNameAndDescription= true;
		try{
			aceptedNameAndDescription = includeProduct.includeProduct(nameProduct, descriptionProduct);
		}
		catch(Exception e){
			aceptedNameAndDescription = false;
		}
		
		
		assertEquals(false, aceptedNameAndDescription);
	}
	
	@Test
	public void testCorretUrlInTheCorrectDBConfiguraion() {
		
		DBConfigure dbconfigure = new DBConfigure();
		
		String testeDbConfigure = dbconfigure.getUrl();
		String correctDBConfigure = "jdbc:mysql://localhost:3306/SisCot";
				
		assertEquals(correctDBConfigure, testeDbConfigure);
	}
	
	@Test
	public void testCorretUserInTheCorrectDBConfiguraion() {
		
		DBConfigure dbconfigure = new DBConfigure();
		
		String testeDbConfigure = dbconfigure.getUser();
		String correctDBConfigure = "siscot";
				
		assertEquals(correctDBConfigure, testeDbConfigure);
	}

	@Test
	public void testCorretPasswordInTheCorrectDBConfiguraion() {
		
		DBConfigure dbconfigure = new DBConfigure();
		
		String testeDbConfigure = dbconfigure.getPassword();
		String correctDBConfigure = "12345";
				
		assertEquals(correctDBConfigure, testeDbConfigure);
	}
	
	@Test
	public void testConnectionDBConnect() {
		
		DBConnect dbconnect = new DBConnect();
		
		Connection testeDbConnect = dbconnect.connect();
				
		assertNotNull(testeDbConnect);
		
	}
}
