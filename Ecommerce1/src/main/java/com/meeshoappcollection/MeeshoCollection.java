package com.meeshoappcollection;

import java.util.HashSet;
import java.util.Set;

import com.meeshoapp.IMeeshoCollection;

public abstract class MeeshoCollection<T> implements IMeeshoCollection<T> {

	protected Set<T> collection = new HashSet<>();
	public MeeshoCollection() {
		super();
		
	}
}
