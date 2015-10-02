package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import model.Pregao;

public class PregaoDAO {
	private Connection connection;
	
	public PregaoDAO() {
			this.connection = new ConnectionFactory().getConnection();
	}
	
	/**
	 * Include in the data base a new pregao
	 * @param A new pregao
	 * @return wasAdd if the pregao was add
	 */
	
	public boolean includePregao(Pregao pregao) {
		String sql = "insert into Pregao (managerName, pregaoDate) values (?,?)";
		//Date date = new Date(pregao.getPregaoDate().getTimeInMillis());
		boolean wasAdd = false;
		
		try {
			System.out.println("values:" + pregao.getManagerName());
			//Prepare param to execut the Query
			PreparedStatement statement =  this.connection.prepareStatement(sql);
			
			statement.setString(1, pregao.getManagerName());
			//statement.setDate(1, date, pregao.getPregaoDate());
			statement.setDate(2, pregao.getPregaoDate());
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
	public ArrayList<Pregao> listPregao() {
		String sql = "select * from Pregao";
		ArrayList<Pregao> pregaoList= new ArrayList<Pregao>();
		
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
				Pregao pregao = new Pregao();

				pregao.setManagerName(rs.getString("managerName"));
				pregao.setPregaoDate(rs.getDate("pregaoDate"));
				pregaoList.add(pregao);
			}
			
			//Close the operators
			statement.close();
			connection.close();
		} catch(SQLException e) {	
			e.printStackTrace();			
			throw new RuntimeException(e);
		}
		
		return pregaoList;
	}
	
	public boolean deletePregao(int id) {
		String sql = "delete from Pregao where id = ?";
		boolean wasDeleted = false;
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			//Set the first atribute of the query
			statement.setInt(1, id);
			statement.execute();
			
			wasDeleted = true;
			
			//Close the operators
			statement.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();			
			throw new RuntimeException(e);
		}
		
		return wasDeleted;
	}
	
	public boolean updateProduct(int idToUpdate, Pregao pregao) {
		String sql = "update Pregao set managerName=?, pregaoDate=? where id=?";
		boolean wasUpdated = false;

		try {
			PreparedStatement statement =  this.connection.prepareStatement(sql);
			
			//Set the first atribute of the query
			statement.setString(1, pregao.getManagerName());
			statement.setDate(2, pregao.getPregaoDate());
			statement.setInt(3, idToUpdate);
			
			statement.executeUpdate();
			
			wasUpdated = true;
			
			//Close the operators
			statement.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return wasUpdated;
	}
	
}
