package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public Connection connect(){
		DBConfigure dbconfigure = new DBConfigure();
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					dbconfigure.getUrl(),
					dbconfigure.getUser(),
					dbconfigure.getPassword()
					);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return connection;
	}
}
