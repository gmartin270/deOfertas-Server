package org.gmartin.deofertas.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class GenericDAOImpl<E, ID extends Serializable> implements IGenericDAO<E, ID> {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Class<? extends E> daoType;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(){
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		daoType = (Class<? extends E>)pt.getActualTypeArguments()[0];
	}
	
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(E entity) {
		currentSession().save(entity);		
	}

	@Override
	public void merge(E entity) {
		currentSession().merge(entity);
	}

	@Override
	public void saveOrUpdate(E entity) {
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void remove(E entity) {
		currentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E load(ID key) {
		return (E)currentSession().get(daoType, key);
	}

	@SuppressWarnings("unchecked")
	public List<E> getAll() {
		return currentSession().createCriteria(daoType).list();
	}

	@SuppressWarnings("unchecked")
	protected List<E> getByCriteria(Criterion... criteriones) {
		Criteria criteria = currentSession().createCriteria(daoType);
		for (Criterion criterion : criteriones) {
			criteria.add(criterion);
		}
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	protected List<E> getByCriteria(List<Criterion> criteriones) {
		Criteria criteria = currentSession().createCriteria(daoType);
		for (Criterion criterion : criteriones) {
			criteria.add(criterion);
		}
		return criteria.list();
	}	
}
