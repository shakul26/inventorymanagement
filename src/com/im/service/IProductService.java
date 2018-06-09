package com.im.service;

import com.im.bean.Product;

public interface IProductService extends IGenericService<Product, String>{

	public boolean addProduct(Product objProduct);
}
