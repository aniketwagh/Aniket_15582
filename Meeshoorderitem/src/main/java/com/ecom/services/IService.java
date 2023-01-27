package com.ecom.services;

import java.util.List;

public interface IService<T> {

	public List<T> findAll();

	public T createNew(T t);

	public T findById(Long id);

	public boolean deleteById(Long id);

	public boolean updateById(Long id, T t);
}
