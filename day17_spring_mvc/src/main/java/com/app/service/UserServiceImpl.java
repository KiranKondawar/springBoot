package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;


@Service// to tell SC  follwing is Spring BEAN conataining BL
@Transactional//Mandatory either service layer or dao layer
public class UserServiceImpl implements IUserService {
//dependancy:dao i/f
	@Autowired
	private IUserDao userDao;
	
	
	@Override
	public User authenticateUser(String email, String pass) {
		
		return userDao.authenticateUser(email, pass);
	}

}
