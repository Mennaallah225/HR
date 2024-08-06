package com.example.hr.servies.impl.v1;

import org.springframework.stereotype.Service;
import com.example.hr.Respository.employeerepo;
import com.example.hr.model.Dto.EmployeeResponDto;
import com.example.hr.model.Dto.v1.EmployeeReqDtov1;
import com.example.hr.model.Entity.Employee;
import com.example.hr.model.mapper.Employeemapper;
import com.example.hr.servies.v1.EmployeeServisv1;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceimpv1 implements EmployeeServisv1 {
	
	private final employeerepo repo ;
	
	private final Employeemapper mapper;
	
		
	
	@Override
	public EmployeeResponDto saveEmployee1(EmployeeReqDtov1 req) {
		Employee emplye= this.mapper.toEntity(req);
		Employee saveEmplo=this.repo.save(emplye);
		return this.mapper.toResponDto(saveEmplo);
	
	  
	}



	
}
