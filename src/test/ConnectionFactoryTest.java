package test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import dao.ConnectionFactory;
import junit.framework.TestCase;

public class ConnectionFactoryTest extends TestCase {
	Connection connection = new ConnectionFactory().getConnection();
	
	@Test
	public void testGetConnection() {		
		assertNotNull(connection);
	}
	
	@Test
	public void testGetConnectionClosed() throws SQLException {
		connection.close();
		
		assertTrue(connection.isClosed());
	}
}
