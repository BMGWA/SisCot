package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;

public class ProductDAO {
	public void includeProduct(Product product) {
		DBConnect dbconnect = new DBConnect();
		Connection connection = dbconnect.connect();
		
		String sql = "insert into Products (nome, description) values (?,?)";
		
		try {
			PreparedStatement statement =  connection.prepareStatement(sql);
			statement.setString(1, product.getProductName());
			statement.setString(2, product.getProductDescription());
			statement.execute();
			
			statement.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Product> listProducts() {
		DBConnect dbconnect = new DBConnect();
		Connection connection = dbconnect.connect();
		
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "select * from Products";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();	
			
			while(rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("nome"));
				product.setProductDescription(rs.getString("description"));
				products.add(product);
			}
			
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
		boolean deleted = false;
		
		String sql = "delete from Products where nome = ?";
		
		DBConnect dbconnect = new DBConnect();
		Connection connection = dbconnect.connect();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nome);
			deleted = true;
			statement.execute();
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deleted;
	}
}
