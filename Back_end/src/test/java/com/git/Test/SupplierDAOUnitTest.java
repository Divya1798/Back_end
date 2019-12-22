package com.git.Test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.git.model.Supplier;
import com.git.DAO.SupplierDAO;

public class SupplierDAOUnitTest 
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}

	
		@Test
		public void addSupplierTest()
		{
			Supplier supplier=new Supplier();
			supplier.setSupplierName("google");
			supplier.setSupplierDesc("ceo of google is : sundar and is present since 1995");
			assertTrue("Problem in adding the Category ",supplierDAO.addSupplier(supplier));
		}

}