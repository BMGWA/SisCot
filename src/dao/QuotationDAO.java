package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Quotation;

public class QuotationDAO {
	private Connection connection;
	
	public QuotationDAO() {
			this.connection = new ConnectionFactory().getConnection();
	}
	
	/**
	 * Include in the data base a new quotation
	 * @param A new quotation
	 * @return wasAdd if the quotation was add
	 */
	
	public boolean includeQuotation(Quotation quotation) {
		String sql = "insert into Quotation (managerName, quotationDate) values (?,?)";
		//Date date = new Date(quotation.getquotationDate().getTimeInMillis());
		boolean wasAdd = false;
		
		try {
			System.out.println("values:" + quotation.getManagerName());
			//Prepare param to execut the Query
			PreparedStatement statement =  this.connection.prepareStatement(sql);
			
			statement.setString(1, quotation.getManagerName());
			//statement.setDate(1, date, quotation.getquotationDate());
			statement.setDate(2, quotation.getQuotationDate());
			statement.execute();
			
			//The product was added
			wasAdd = true;
			
			//Close the operators
			statement.close();
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
	public ArrayList<Quotation> listQuotation() {
		String sql = "select * from Quotation";
		ArrayList<Quotation> quotationList= new ArrayList<Quotation>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			//Returns a result of the query of search
			ResultSet rs = statement.executeQuery();	
			
			//Stores all the products listed in the array
			while(rs.next()) {
				Quotation quotation = new Quotation();

				quotation.setManagerName(rs.getString("managerName"));
				quotation.setQuotationDate(rs.getDate("quotationDate"));
				quotation.setId(rs.getInt("id"));
				quotationList.add(quotation);
			}
			
			//Close the operators
			statement.close();
		} catch(SQLException e) {	
			e.printStackTrace();			
			throw new RuntimeException(e);
		}
		
		return quotationList;
	}
	
	public boolean deleteQuotation(int id) {
		String sql = "delete from Quotation where id = ?";
		boolean wasDeleted = false;
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			//Set the first atribute of the query
			statement.setInt(1, id);
			statement.execute();
			
			wasDeleted = true;
			
			//Close the operators
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();			
			throw new RuntimeException(e);
		}
		
		return wasDeleted;
	}
	
	public boolean updateQuotation(int idToUpdate, Quotation quotation) {
		String sql = "update Quotation set managerName=?, quotationDate=? where id=?";
		boolean wasUpdated = false;

		try {
			PreparedStatement statement =  this.connection.prepareStatement(sql);
			
			//Set the first atribute of the query
			statement.setString(1, quotation.getManagerName());
			statement.setDate(2, quotation.getQuotationDate());
			statement.setInt(3, idToUpdate);
			
			statement.executeUpdate();
			
			wasUpdated = true;
			
			//Close the operators
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return wasUpdated;
	}
	
}
