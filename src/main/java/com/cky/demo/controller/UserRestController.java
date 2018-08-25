package com.cky.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cky.demo.exception.NotFoundException;
import com.cky.demo.model.User;
import com.cky.demo.service.UserService;

/**
 * @author chandrakumar
 *
 */
@RestController
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<?> getUsers() {

		List<User> users= userService.list();

		return new ResponseEntity<>(users,HttpStatus.OK);	
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {

		User user= userService.getById(id);
		if(user==null){
			throw new NotFoundException("User with id="+id+" not found");
		}

		return new ResponseEntity<>(user,HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<?> post(@RequestBody User user) {

		 userService.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);	
	}
	
	@PutMapping
	public ResponseEntity<?> put(@RequestBody User user) {

		 userService.saveOrUpdate(user);
		return new ResponseEntity<>(HttpStatus.CREATED);	
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		User user= userService.getById(id);
		if(user==null){
			throw new NotFoundException("User with id="+id+" not found");
		}
		
		userService.delete(user);

		return new ResponseEntity<>(HttpStatus.OK);	
	}
}
