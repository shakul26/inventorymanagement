package com.im.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.im.bean.Product;
import com.im.dao.GenericDaoImpl;
import com.im.dao.IProductDao;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, String> implements IProductService{

	private IProductDao productDao;
	
	
	public ProductServiceImpl() {
	
	}
	@Autowired
	public ProductServiceImpl(@Qualifier("productDaoImpl") GenericDaoImpl<Product, String> genricDao){
		
		super(genricDao);
		this.productDao = (IProductDao) genricDao;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addProduct(Product objProduct) {
		
		return productDao.addProduct(objProduct);
	}

	
}
