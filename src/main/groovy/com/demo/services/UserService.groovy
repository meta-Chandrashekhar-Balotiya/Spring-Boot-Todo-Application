package com.demo.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.demo.dao.UserDao
import com.demo.entities.Folder
import com.demo.entities.Users

@Service
class UserService {
	
	@Autowired
	private UserDao userRepository
	
	public String addUser(Users user) {
		
		Users u = this.userRepository.findByUsername(user.getUsername())
		if(u != null) {
			return "user already exists"
		}
		
		Folder folder = new Folder("default",user)
		
		user.setFolders(List.of(folder))
		this.userRepository.save(user)
		
		return "user added successfuly"
	}
	
}
