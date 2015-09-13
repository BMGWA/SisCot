package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;

public class ProductDAO {
	
	/**
	 * Include in the data base a new product
	 * @param A new product
	 * @return wasAdd if the product was add
	 */
	public boolean includeProduct(Product product) {
		
		//Connect with data base
		DBConnect dbconnect = new DBConnect();
		Connection connection = dbconnect.connect();
		
		//Query to add new product
		String sql = "insert into Products (nome, description) values (?,?)";
		
		//Flag to verify if the product was add in database
		boolean wasAdd = false;
		
		try {
			//Prepare param to execut the Query
			PreparedStatement statement =  connection.prepareStatement(sql);
			statement.setString(1, product.getProductName());
			statement.setString(2, product.getProductDescription());
			statement.execute();
			
			//The product was added
			wasAdd = true;
			
			//Close the operators
			statement.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return wasAdd;
	}
	
	/**
	 * Shows all existing products in the database 
	 * @return
	 */
	public ArrayList<Product> listProducts() {
		
		//Connect with data base
		DBConnect dbconnect = new DBConnect();
		Connection connection = dbconnect.connect();
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Query to add new product
		String sql = "select * from Products";
		//Stores the products listed
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//Returns a result of the query of search
			ResultSet rs = statement.executeQuery();	
			
			//Stores all the products listed in the array
			while(rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("nome"));
				product.setProductDescription(rs.getString("description"));
				products.add(product);
			}
			
			//Close the operators
			statement.close();
			connection.close();
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return products;
	}
	
	public boolean deleteProduct(String nome) {		

		//Create a sql comand for delete the product with nama equal params recive 
		String sql = "delete from Products where nome = ?";
		
		//Connect with data base
		DBConnect dbconnect = new DBConnect();
		Connection connection = dbconnect.connect();
		
		//Flag to verify if the product was deleted in database
		boolean deleted = false;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//Set the first atribute of the query
			statement.setString(1, nome);
			deleted = true;
			statement.execute();
			//Close the operators
			statement.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return deleted;
	}
	
	public boolean updateProduct(String nameToUpdate, Product product){
		
		boolean wasUpdate = false;
		
		//Create a sql comand for delete the product with nama equal params recive


		String sql = "update Products set description=?, nome=? where nome=?";

		
		//Connect with data base
		DBConnect dbconnect = new DBConnect();
		Connection connection = dbconnect.connect();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//Set the first atribute of the query
			statement.setString(1, product.getProductDescription());
			statement.setString(2, product.getProductName());
			statement.setString(3, nameToUpdate);
			
			wasUpdate = true;
			statement.executeUpdate();
			
			//Close the operators
			statement.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return wasUpdate;
	}
}
