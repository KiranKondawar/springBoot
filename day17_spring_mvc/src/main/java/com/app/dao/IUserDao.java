package com.app.dao;

import com.app.pojos.User;

public interface IUserDao {
// ADD a method for user authentification
	User authenticateUser(String email,String pass);
	
}
