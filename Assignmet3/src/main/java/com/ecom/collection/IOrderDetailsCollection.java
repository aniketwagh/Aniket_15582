package com.ecom.collection;

import java.util.List;

public interface IOrderDetailsCollection<T> {
	List<T> findAll();

	T findOne(int id);

	boolean createNew(T t);

	boolean findOneAndDelete(int id);
}
