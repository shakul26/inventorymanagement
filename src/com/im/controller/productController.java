package com.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.im.bean.Product;
import com.im.service.IProductService;


@Controller
public class productController {
	
	@Autowired(required = true)
	private IProductService productService;
	

	@RequestMapping(value = "/home", method= RequestMethod.GET)
	public String test(Model model){
		
		return "home";
	}
	
	@RequestMapping(value = "/getproduct", method= RequestMethod.GET)
	public String getProductPage(Model model){
		
		System.out.println("*********** GET PRODUCT CALLED *************");
		Product objProduct = new Product();
		model.addAttribute("product", objProduct);
		return "product";
	}
	
	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product objProduct, Model model){
		
		productService.add(objProduct);
		
		return "product";
	}
}
