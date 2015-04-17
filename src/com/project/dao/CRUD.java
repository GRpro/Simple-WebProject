package com.project.dao;

import java.util.List;

import com.project.exceptions.OperationFailedException;

public interface CRUD<E> {
	
	public long create(E object) throws OperationFailedException;
	public E get(long id) throws OperationFailedException;
	public List<E> getAll() throws OperationFailedException;
	public void update(E object) throws OperationFailedException;
	public void delete(long id) throws OperationFailedException;
	

}
