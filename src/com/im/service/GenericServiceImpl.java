package com.im.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.im.dao.IGenericDao;


/**
 * 
 * @author Shakul Dubey
 * @Details
 * Every method is annotated as @Transactional. 
 * Thus, we guarantee that every database operation will be wrapped with transaction. 
 * Also note that genericDao field initiailization has to be made in the sub-classes of GenericDaoImpl by using parameterized 
 * constructor. The reason behind is that when multiple entity service classes which extends base GenericServiceImpl is used, 
 * Spring has to decide which injection is made. 
 * Therefore, we allow sub entity service classes to decide 
 * which generic dao object will be injected by using @Qualifier annotation. 
 * @param <E>
 * @param <K>
 */
@Service
public abstract class GenericServiceImpl<E, K> implements IGenericService<E, K> {

	
	private IGenericDao<E, K> genricDao;
	
	public GenericServiceImpl(IGenericDao<E, K> genricDao) {
		
		this.genricDao = genricDao;
	}
	
	public GenericServiceImpl() {
	
	}
	
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdate(E entity) {
		
		genricDao.saveOrUpdate(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> getAll() {
		
		return genricDao.getAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public E get(K id) {
	
		return get(id);
	}

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(E entity) {
		
		genricDao.add(entity);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(E entity) {
		genricDao.update(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(E entity) {
		
		genricDao.remove(entity);
	}


}
