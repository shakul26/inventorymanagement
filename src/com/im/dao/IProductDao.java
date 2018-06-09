package com.im.dao;

import com.im.bean.Product;

public interface IProductDao extends IGenericDao<Product, String>{

	public boolean addProduct(Product objProduct);
}
