package com.demo.dao

import org.springframework.data.repository.CrudRepository

import com.demo.entities.Users

public interface UserDao extends CrudRepository<Users,String>{
	
	Users findByUsername(String username)
	
	String deleteByUsername(String username)

}
