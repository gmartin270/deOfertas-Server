package org.gmartin.deofertas.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<E, ID extends Serializable> {

	public void add(E entity);
	
	public void merge(E entity);

	public void saveOrUpdate(E entity);

	public void remove(E entity);
	
	public E load(ID key);
	
	public List<E> getAll();

}
