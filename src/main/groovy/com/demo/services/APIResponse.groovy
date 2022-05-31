package com.demo.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {

	int recordCount
	T response
	
	public APIResponse(int recordCount, T response) {
		
		this.recordCount = recordCount;
		this.response = response;
	}
	
	
}
