package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;
@Repository//Mandatory to tell spring container ,following is a spring bean containing Data access logic
//Enables  excution transaltion (checked/unchecked--> spring specific unchecked exection)

public class UserDaoImpl implements IUserDao {
//dependecy Session Factory
	@Autowired
	private SessionFactory sf;
	@Override
	public User authenticateUser(String email, String pass) {
		String jpql="Select u from User u join u.roles where u.email=:em and u.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email)
				.setParameter("pass", pass).getSingleResult();
		
	}//rerturn user +role infpormation in single query

}
