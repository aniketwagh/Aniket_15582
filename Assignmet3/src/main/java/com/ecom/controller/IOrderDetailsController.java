package com.ecom.controller;

import java.util.List;

public interface IOrderDetailsController<T> {
	List<T> findAll();

	T findOne(int id);

	boolean createNew(T t);

	boolean findOneAndDelete(int id);
}
