package com.example.hr.utilities;

import org.springframework.stereotype.Component;

import com.example.hr.servies.EmployeeServies;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Employeeuntitiy {
	private final EmployeeServies es;
	
	public String getdetilesEmployeebyid(long id) {
		return this.es.getdetilesEmployeebyid(id);
		
	}

	
}
