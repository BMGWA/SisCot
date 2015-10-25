package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;
import model.Quotation;

public class ReportDAO {

	private Connection connection;

	public ReportDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public ArrayList<String> listProductsManager(int id) {
		String sql = "select productName from Quotation_Product_Provider " + "where quotationID = ?";
		ArrayList<String> productsManager = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setInt(1, id);

			// Returns a result of the query of search
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			while (rs.next()) {

				String product;
				product = rs.getString("productName");

				productsManager.add(product);
			}

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return productsManager;
	}

	public ArrayList<String> listProvidersManager(int id) {
		
		String sql = "select providerName from Quotation_Product_Provider " + "where quotationID = ?";
		ArrayList<String> providersManager = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setInt(1, id);

			// Returns a result of the query of search
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			while (rs.next()) {

				String product;
				product = rs.getString("providerName");

				providersManager.add(product);
			}

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return providersManager;
	}

	public ArrayList<String> listProductsProvider(int id, String providerName) {
		String sql = "select productName from Quotation_Product_Provider " +
				"where quotationID = ? AND where providerName = ?";
		ArrayList<String> productsManager = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			statement.setString(2, providerName);

			// Returns a result of the query of search
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			while (rs.next()) {

				String product;
				product = rs.getString("productName");

				productsManager.add(product);
			}

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return productsManager;
	}

	public ArrayList<String> listProvidersProvider(int id, String providerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
