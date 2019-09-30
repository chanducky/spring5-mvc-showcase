package com.cky.demo.dao;

import java.util.List;

import com.cky.demo.model.User;

public interface UserDao {
	void save(User user);
//testing pull request on a tutorial
	List<User> list();

	User getById(Long id);

	void saveOrUpdate(User user);

	void delete(User user);
}
