package dao;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

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
