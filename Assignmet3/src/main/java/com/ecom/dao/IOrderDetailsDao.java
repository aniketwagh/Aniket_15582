package com.ecom.dao;

import java.util.List;

public interface IOrderDetailsDao<T> {

	List<T> findAll();

	T findOne(int id);

	boolean createNew(T t);

	boolean findOneAndDelete(int id);
}
