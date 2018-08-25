package com.cky.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author chandrakumar
 *
 */
@Entity
@Table(name = "TBL_USERS")
public class User {

	@Id
	//@GeneratedValue
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "USER_NAME")
	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	@NotEmpty(message="Please Enter your name")
	private String name;

	@Column(name = "USER_EMAIL", unique = true)
	@Email(message = "{user.email.invalid}")
	@NotEmpty(message="Please Enter your email")
	private String email;

	@Temporal(value = TemporalType.TIMESTAMP)
	Date createdAt;   
	
	@Temporal(value = TemporalType.TIMESTAMP)
	Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
