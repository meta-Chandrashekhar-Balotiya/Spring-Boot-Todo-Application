package com.demo.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

import org.springframework.security.core.userdetails.User
import com.demo.dao.UserDao
import com.demo.entities.Users

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserDao userRepository
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		println "User Details .. with username ${username} is :  "
		
//		if(username.equals("tester")) {
//			return new User("tester", "tester", new ArrayList<>())
//		}else {
//			throw new UsernameNotFoundException("User Not Found 404 ")
//		}
				
		Users user = userRepository.findByUsername(username)
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>())
		
	}
	
}
