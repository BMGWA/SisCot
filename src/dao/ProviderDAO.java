package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Provider;

public class ProviderDAO {
	
	public boolean insertProvider(Provider provider) {
		boolean wasAdd = false;
		String sql = "insert into Providers";
		
		DBConnect dbconnect = new DBConnect();
		Connection connection = dbconnect.connect();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, provider.getProviderCnpj());
			statement.setString(2, provider.getProviderName());
			statement.setString(9, provider.getProviderEmail());
			statement.setString(3, provider.getProviderPassword());
			statement.setInt(4, provider.getProviderDdd());
			statement.setInt(5, provider.getProviderPhone());
			statement.setString(6, provider.getProviderAdress());
			statement.setString(7, provider.getProviderCity());
			statement.setString(8, provider.getProviderState());
			statement.setString(10, provider.getProviderCnpj());			
			statement.execute();
			
			wasAdd = true;
			
			statement.close();
			connection.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return wasAdd;
	}
	
	public ArrayList<Provider> listProviders() {
		DBConnect dbconnect = new DBConnect();
		Connection connection = dbconnect.connect();
		
		String sql = "select * from Providers";
		ArrayList<Provider> providers = new ArrayList<Provider>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Provider provider = new Provider();
				
				provider.setProviderCnpj(rs.getString("cnpj"));
				provider.setProviderName(rs.getString("nome"));
				provider.setProviderEmail(rs.getString("email"));
				provider.setProviderPassword(rs.getString("senha"));
				provider.setProviderDdd(rs.getInt("ddd"));
				provider.setProviderPhone(rs.getInt("telefone"));
				provider.setProviderAdress(rs.getString("endereco"));
				provider.setProviderCity(rs.getString("cidade"));
				provider.setProviderState(rs.getString("estado"));
				provider.setProviderZip(rs.getInt("cep"));
				
				providers.add(provider);
			}
			
			statement.close();
			connection.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return providers;
	}
	
	public boolean deleteProvider(String providerCnpj) {
		boolean wasDeleted = false;
		String sql = "delete from Providers where nome = ?";
		
		DBConnect dbconnect = new DBConnect();
		Connection connection = dbconnect.connect();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, providerCnpj);
			statement.execute();
			
			wasDeleted = true;
			
			statement.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return wasDeleted;
	}
	
public boolean updateProvider(String cnpjToUpdate, Provider provider){		
		boolean wasUpdated = false;
		String sql = "update Provider set cnpj=?, nome=?, email=?, senha=?, ddd=?, "
				+ "telefone=?, endereco=?, cidade=?, estado=?, cep=? where cnpj=?";

		DBConnect dbconnect = new DBConnect();
		Connection connection = dbconnect.connect();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, provider.getProviderCnpj());
			statement.setString(2, provider.getProviderName());
			statement.setString(3, provider.getProviderEmail());
			statement.setString(4, provider.getProviderPassword());
			statement.setInt(5, provider.getProviderDdd());
			statement.setInt(6, provider.getProviderPhone());
			statement.setString(7, provider.getProviderAdress());
			statement.setString(8, provider.getProviderCity());
			statement.setString(9, provider.getProviderState());
			statement.setInt(10, provider.getProviderZip());
			statement.setString(11, cnpjToUpdate);
			
			statement.executeUpdate();
			wasUpdated = true;
			
			statement.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return wasUpdated;
	}

}
