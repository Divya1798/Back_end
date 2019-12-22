package com.git.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.git.DAO.CategoryDAO;
import com.git.DAO.ProductDAO;
import com.git.DAO.UserDAO;
import com.git.model.Category;
import com.git.model.Product;
import com.git.model.UserDetail;

public class ManualTest 
{
	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.git");
		context.refresh();
		
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
		Category category=new Category();
		category.setCategoryName("SamsungMobile");
		category.setCategoryDesc("All Variety of Samsung Mobile");
		
		categoryDAO.addCategory(category);
		
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		Product product = new Product();
		product.setProductName("Samsung J7");
		product.setProductDesc(" mobile with 4G and 13MP Back camera");
		product.setPrice(12000);
		product.setStock(50);
		product.setCategoryId(2);
		product.setSupplierId(1);
		productDAO.addProduct(product);

		
	}
}