package com.demo.validation

import org.springframework.context.annotation.Configuration

import com.demo.entities.Todo

@Configuration
public class TodoValidation {

	public todoIsValid(Todo todo) {
		
		String tittle = todo.getTaskTitle()
		String description = todo.getTaskDescription()
		String status = todo.getStatus()
		Date date = todo.getEndDate()
		
		if(isTittleValid(tittle) && isDescriptionValid(description) && isStatusValid(status) && isDateValid(date)) {
			return true
		}else {
			return false;
		}
		
	}
	
	public boolean isTittleValid(String tittle) {
		
		if(tittle.size() == 0) {
			return false
		}else {
			return true
		}
	}
	
	public boolean isDescriptionValid(String description) {
		
		if(description.size() == 0) {
			return false
		}else {
			return true
		}
	}
	
	public boolean isStatusValid(String status) {

	if(status.size() == 0) {
			return false
		}else {
			return true
		}
	}
	
	public boolean isDateValid(Date endDate) {
		
		return true
	}
	
	
}
