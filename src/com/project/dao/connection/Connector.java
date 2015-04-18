package com.project.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Connector {

	private static Connection connection;	
	
	private static Connection connect() {
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			
//			return (Connection) DriverManager.getConnection(
//					"jdbc:mysql://localhost/shop_service_db?user=root&password=root");
//		} catch (InstantiationException | IllegalAccessException
//				| ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;

		try {
			//find DataSourse using JNDI
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/DataSource");
			Connection conn = ds.getConnection();
			
			return conn;
		} catch (NamingException e) {
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
