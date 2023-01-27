package com.ecom.services;

import java.util.List;

public interface IService<T> {

	List<T> findAll();

	T findById(final Long id);

	T create(T t);

	boolean delete(final Long id);

	boolean findOneAndUpdate(final Long id, T t);
}
