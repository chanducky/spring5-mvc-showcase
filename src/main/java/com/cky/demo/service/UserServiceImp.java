package com.cky.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cky.demo.dao.UserDao;
import com.cky.demo.model.User;

/**
 * @author chandrakumar
 *
 */
@Transactional
@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	
	public void save(User user) {
		user.setCreatedAt(new Date());
		userDao.save(user);
	}

	@Override
	public void saveOrUpdate(User user) {
		user.setUpdatedAt(new Date());
		userDao.saveOrUpdate(user);
	}
	
	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public User getById(Long id){
		return userDao.getById(id);
	}
	
	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
}
