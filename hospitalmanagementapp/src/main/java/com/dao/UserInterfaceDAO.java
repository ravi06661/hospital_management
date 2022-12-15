package com.dao;

import com.model.User;

public interface UserInterfaceDAO {
	
	public boolean insertUser(User user);
	public User viewUserById(int id);
	public boolean loginUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);

}
