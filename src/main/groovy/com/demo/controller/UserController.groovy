package com.demo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.demo.dao.UserDao
import com.demo.entities.AuthenticationResponse
import com.demo.entities.Users
import com.demo.services.CustomUserDetailService
import com.demo.services.UserService
import com.demo.utils.JwtUtil

@RestController
public class UserController {
	
	@Autowired
	private UserService userService
	
	@Autowired
	private AuthenticationManager authenticationManager

	@Autowired
	private CustomUserDetailService myUserDetailsService

	@Autowired
	private JwtUtil jwtUtil
	

	//@PostMapping("/token")
	@RequestMapping(value="/token", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Users authenticationRequest) throws Exception {
		
		println("check")
		try {
			authenticationManager.authenticate(	new UsernamePasswordAuthenticationToken(
												authenticationRequest.getUsername(), authenticationRequest.getPassword()))
		}catch(BadCredentialsException exp) {
			throw new Exception("Incorrect username and password",exp)
		}

		UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername())
		println " userDetails in UserController : " + userDetails

		final String jwt = this.jwtUtil.generateToken(userDetails)
		println "Token : " +  jwt

		return ResponseEntity.ok(new AuthenticationResponse(jwt))
	}
	
	
	@PostMapping("/user")
	public String addUser(@RequestBody Users user) {
		println "New User"
		return this.userService.addUser(user)
		
	}

}
