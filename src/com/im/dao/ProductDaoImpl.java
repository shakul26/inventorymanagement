package com.im.dao;

import org.springframework.stereotype.Repository;

import com.im.bean.Product;

/**
 * 
 * @author Shakul Dubey
 * @Details
 * This class contains Dao operation related to Product
 */

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product, String> implements IProductDao{

	/**
	 * @author Shakul Dubey
	 * @Details
	 * To persist Product in Database
	 */
	@Override
	public boolean addProduct(Product objProduct) {
		// TODO Auto-generated method stub
		boolean retVal =false;
		try {
			add(objProduct);
			retVal = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retVal;
	}

}
