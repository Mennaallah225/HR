package com.example.hr.servies.impl;


import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.hr.Respository.employeerepo;
import com.example.hr.model.Dto.EmployeeDto;
import com.example.hr.model.Dto.EmployeeReqDto;
import com.example.hr.model.Dto.EmployeeResponDto;
import com.example.hr.model.Dto.EmployeeupdateDto;
import com.example.hr.model.Entity.Employee;
import com.example.hr.model.mapper.Employeemapper;
import com.example.hr.servies.EmployeeServies;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceimp implements EmployeeServies {
	
	private final employeerepo repo ;
	
	private final Employeemapper mapper;
//	private final java.util.logging.Logger logger= LogManager.getLogManager().getLogger(this.getClass().getName());
		
	
	@Override
	public EmployeeResponDto saveEmployee(EmployeeReqDto req) {
//		String correlandId=UUID.randomUUID().toString();
		log.info("employee save  : {}the user fullname: {}  correlandId : {}  " , req.getEmail(),req.getName());
		Employee emplye= this.mapper.toEntity(req);
		Employee saveEmplo=this.repo.save(emplye);
		return this.mapper.toResponDto(saveEmplo);
	
	  
	}
	@Override
	public EmployeeResponDto saveEmployee11(EmployeeReqDto req) {
		Employee emplye= this.mapper.toEntity(req);
//		emplye.setToken(UUID.randomUUID().toString());
		Employee saveEmplo=this.repo.save(emplye);
		return this.mapper.toResponDto(saveEmplo);
	
	  
	}



	@Override
	public String getdetilesEmployeebyid(long id) {
		Optional<Employee> byid=this.repo.findById(id);
		return  byid.get().getEmail() + " / " + byid.get().getName();
	}



	@Override
	public EmployeeResponDto updateEmployee(EmployeeupdateDto req) throws Exception {
		Optional<Employee> byid=this.repo.findById(req.getId());
		if( !byid.isPresent()) {
			
			log.error("you can’t update ");
			throw new Exception("you cant update");
		}
		Employee entity= this.mapper.toEntity(req);	
		Employee save= this.repo.save(entity);
		return this.mapper.toResponDto(save);
	}



	@Override
	public void deleteemployeebyid(long id) {
		
		this.repo.deleteById(id);
		
	}



	@Override
	public EmployeeDto get(long id) {
		Optional<Employee> getId= this.repo.findById(id);
		
		return this.mapper.toDto(getId.get());
	}



	
}
