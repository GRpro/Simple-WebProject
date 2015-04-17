package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.project.dao.connection.Connector;
import com.project.entities.Item;
import com.project.exceptions.OperationFailedException;

public class ItemDAO implements CRUD<Item>{

	private static ItemDAO itemDAO;
	private Connection connection;
	
	private ItemDAO() {
		this.connection = Connector.getConnection();
	}
	
	
	public static ItemDAO getInstance() {
		if (itemDAO == null) {
			itemDAO = new ItemDAO();
		}
		return itemDAO;
	}
	
	
	@Override
	public long create(Item object) throws OperationFailedException {
		PreparedStatement statement = null;
		long id = 0;
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(
					"INSERT INTO item (name, price, shop_id) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, object.getName());
			statement.setFloat(2, object.getPrice());
			statement.setLong(3, object.getShopId());
			if(statement.executeUpdate() != 1)
				throw new SQLException();
			ResultSet resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
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
		return id;
	}

	@Override
	public Item get(long id) throws OperationFailedException{
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Item> getByShopId(long shopId) throws OperationFailedException {
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT id, name, price FROM item WHERE shop_id = ?");
			statement.setLong(1, shopId);
			List<Item> items = new LinkedList<>();
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Item item = new Item();
				item.setId(resultSet.getLong(1));
				item.setName(resultSet.getString(2));
				item.setPrice(resultSet.getFloat(3));
				items.add(item);
			}
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OperationFailedException();
		}
	}

	@Override
	public List<Item> getAll() throws OperationFailedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Item object) throws OperationFailedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) throws OperationFailedException {
		PreparedStatement statement = null;
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement("DELETE from item WHERE id = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
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
	
	public void deleteByShopId(long id) throws OperationFailedException {
		PreparedStatement statement = null;
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement("DELETE from item WHERE shop_id = ?");
			statement.setLong(1, id);
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
