package com.im.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @author Shakul Dubey
 * Basic DAO operations dependent with Hibernate's specific classes
 * @see SessionFactory
 * 
 * @Details
 * 
 * This class is marked as abstract, so it can be used only through specific entity DAO implementations. 
 * The most important part of this class is its constructor implementation. 
 * This is where all the magic will happen. 
 * In order to keep things as clean as possible and to avoid AOP and other techniques, 
 * we use this hack: we get the actual parametrized type of a concrete class, 
 * store it in a Class variable, and use it in EntityManager’s methods.
 * Because this class is marked as abstract, getClass().getGenericSuperclass(); 
 * 
 */
@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<E, K extends Serializable> implements IGenericDao<E, K> {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Class<? extends E> daoType;
	
	
	   /**
	    * By defining this class as abstract, we prevent Spring from creating 
	    * instance of this class If not defined as abstract, 
	    * getClass().getGenericSuperClass() would return Object. There would be 
	    * exception because Object class does not hava constructor with parameters.
	    */

	@SuppressWarnings("rawtypes")
	public GenericDaoImpl(){
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType)t;
		
		daoType = (Class) pt.getActualTypeArguments()[0];
		
	}
	
	protected Session currentSession(){
		
		return sessionFactory.getCurrentSession();
	}
	
	

    @Override
    public void add(E entity) {
        currentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(E entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(E entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void remove(E entity) {
        currentSession().delete(entity);
    }

    @Override
    public E find(K key) {
        return (E) currentSession().get(daoType, key);
    }

    @Override
    public List<E> getAll() {
        return currentSession().createCriteria(daoType).list();
    }
}
