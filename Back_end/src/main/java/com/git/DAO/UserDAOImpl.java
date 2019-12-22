package com.git.DAO;

//import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.git.model.Product;
import com.git.model.UserDetail;

@Repository("userDAO")
@Transactional

public class UserDAOImpl  implements  UserDAO
{
@Autowired
SessionFactory sessionFactory;
	public boolean registerUser(UserDetail userDetail) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(userDetail);
		
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteUser(UserDetail userDetail) 
	{
		try 
		{
			sessionFactory.getCurrentSession().delete(userDetail); 
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	
	}

	public boolean updateUser(UserDetail userDetail)
	{
		try 
		{
			sessionFactory.getCurrentSession().update(userDetail); 
				
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


	

	public List<UserDetail> listUserDetails() {
		
		Session session=sessionFactory.openSession();
		List<UserDetail> listUserDetails=(List<UserDetail>)session.createQuery("from UserDetail").list();
		session.close();
		return  listUserDetails;
	}

	
	public UserDetail getUser(String username) 
	
	{
		Session session=sessionFactory.openSession();
		UserDetail user=(UserDetail)session.get(UserDetail.class,username);
		session.close();
		return user;
	}


}
