package com.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.project.dao.connection.Connector;
import com.project.entities.Shop;
import com.project.exceptions.OperationFailedException;

public class ShopDAO implements CRUD<Shop>{

	private static ShopDAO shopDAO;
	private Connection connection;
	
	private ItemDAO itemDAO;
	
	private ShopDAO() {
		this.connection = Connector.getConnection();
		this.itemDAO = ItemDAO.getInstance();
	}
	
	
	public static ShopDAO getInstance() {
		if (shopDAO == null) {
			shopDAO = new ShopDAO();
		}
		return shopDAO;
	}


	@SuppressWarnings("finally")
	@Override
	public long create(Shop object) throws OperationFailedException {
		PreparedStatement statement = null;
		long id = 0;
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(
					"INSERT INTO shop (name, address) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, object.getName());
			statement.setString(2, object.getAddress());
			if(statement.executeUpdate() != 1)
				throw new SQLException();
			ResultSet resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				throw new OperationFailedException();
			}
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Shop get(long id) throws OperationFailedException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Shop> getAll() throws OperationFailedException {
		PreparedStatement statement = null;
		List<Shop> shops = new LinkedList<>();
		long id = 0;
		try {
			statement = connection.prepareStatement("SELECT id, name, address FROM shop");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Shop shop = new Shop();
				shop.setId(resultSet.getLong(1));
				shop.setName(resultSet.getString(2));
				shop.setAddress(resultSet.getString(3));
				shops.add(shop);
			}
			return shops;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OperationFailedException();
		}
	}


	@Override
	public void update(Shop object) throws OperationFailedException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(long id) throws OperationFailedException {
		PreparedStatement statement = null;
		try {
			connection.setAutoCommit(false);
//			//delete all items related to this shop
//			itemDAO.deleteByShopId(id);
			
			statement = connection.prepareStatement("DELETE from shop WHERE id = ?");
			statement.setLong(1, id);
			if(statement.executeUpdate() != 1)
				throw new SQLException();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new OperationFailedException();
			}
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	

}
