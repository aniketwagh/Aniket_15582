package com.meeshoapp;

import java.util.Set;


public interface IMeeshoCollection<T> {

	abstract Set<T> getList();
	
	public abstract String createNewProduct(T productName);
	
	public abstract String updatebyId(T entity, int Id);
	
	public abstract T findById(int Id);
	
	public abstract String deleteById(int Id);

}
