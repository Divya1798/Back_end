package com.git.Config;



import java.util.Locale.Category;
import java.util.Properties;
import java.util.function.Supplier;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.git.model.Cart;
import com.git.model.OrderDetail;
import com.git.model.Product;
import com.git.model.UserDetail;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.git*")

public class DBConfig {
	@Bean(name="dataSource")
	
	//1.Create  a DataSource object
	public DataSource getH2DataSource() {
		DriverManagerDataSource  datasource=new DriverManagerDataSource();
		
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUsername("divya");
		datasource.setPassword("123");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/project1");
		System.out.println("===Creating DataSource Bean==");
		return datasource;
		
	}
	
	//2. Create a SessionFactory object
	@Bean(name="SessionFactory")
	public SessionFactory getSessionFactory() {
	Properties hibernateproperties=new Properties();
		hibernateproperties.put("hibernate.hbm2ddl.auto","update");
		
		hibernateproperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(getH2DataSource());
		factory1.addProperties(hibernateproperties)	;
		
		factory1.addAnnotatedClass(Category.class);
		factory1.addAnnotatedClass(Supplier.class);
		factory1.addAnnotatedClass(Product.class);
		factory1.addAnnotatedClass(UserDetail.class);
		factory1.addAnnotatedClass(Cart.class);	
		factory1.addAnnotatedClass(OrderDetail.class);	
		SessionFactory sessionFactory=factory1.buildSessionFactory();
		System.out.println("===Creating the SessionFactory Bean====");
		return sessionFactory;
		
	}
	
	//3. Create a HibernateTransactionManager
	@Bean(name="txManager")
	
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Creating the TransactionManager Bean");
		return new HibernateTransactionManager(sessionFactory);
		
	}
	
	
	
}