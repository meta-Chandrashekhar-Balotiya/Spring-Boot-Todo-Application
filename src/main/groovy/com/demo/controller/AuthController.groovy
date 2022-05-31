package com.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
public class AuthController {
	
	@GetMapping("/welcome")
	@ResponseBody
	public String welcome() {
		println "Welcome Function"
		return "You are Welcome new User .. "
	}
	
	
}
