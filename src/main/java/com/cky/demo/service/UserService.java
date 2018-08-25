package com.cky.demo.service;

import java.util.List;

import com.cky.demo.model.User;

/**
 * @author chandrakumar
 *
 */
public interface UserService {
	void save(User user);

	List<User> list();

	User getById(Long id);

	void delete(User user);

	void saveOrUpdate(User user);
}
