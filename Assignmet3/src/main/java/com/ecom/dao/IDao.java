package com.ecom.dao;

import java.util.List;

public interface IDao<T> {
	List<T> findAll();

	T findOne(int id);

	boolean createNew(T t);

	boolean findOneAndDelete(int id);

	boolean findOneAndUpdate(int id, T t);
}
