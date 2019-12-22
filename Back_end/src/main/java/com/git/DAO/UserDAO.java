package com.git.DAO;

import java.util.List;


import com.git.model.UserDetail;

public interface UserDAO {
	

	public boolean registerUser(UserDetail userDetail);
	public boolean deleteUser(UserDetail userDetail);
	public boolean updateUser(UserDetail userDetail);
	public UserDetail getUser(String username);
	

}
