package com.project.dao.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Connector {

	private static Connection connection;
	
	private static Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			return (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/shop_service_db?user=root&password=root");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method always returns a single instance of Connection
	 * @return connection instance
	 */
	public static Connection getConnection() {
		if(connection == null)
			connection = connect();
		return connection;
	}
}
