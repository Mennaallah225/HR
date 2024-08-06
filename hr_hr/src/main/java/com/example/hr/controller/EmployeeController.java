package com.example.hr.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.hr.model.Dto.EmployeeDto;
import com.example.hr.model.Dto.EmployeeReqDto;
import com.example.hr.model.Dto.EmployeeResponDto;
import com.example.hr.model.Dto.EmployeeupdateDto;
import com.example.hr.servies.EmployeeServies;
import com.example.hr.utilities.Employeeuntitiy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController

@RequestMapping("/employees")
//  Constructor  دي بدل Autowired  واسهل بتعمل 
@RequiredArgsConstructor    
@Slf4j

public class EmployeeController {
	

	private  final  EmployeeServies es;
	private final Employeeuntitiy employeeuntitiy;
//	private final  Logger logger = LogManager.getLogManager().getLogger(this.getClass().getName());
	
//	@GetMapping دي الطريقه الصح لكتابة 
	
	
	
//	@RequestParam vs @PathVariable الفرق بين هو 
//RequestParam  في السيرش علي حاجات كتير  وتانيه عكسها 	لو  
	
	
	@GetMapping("/employee/{id}")
public EmployeeDto getemployeeByPathVariable(@PathVariable(name = "id") long id) {
		log.info("Empolyee ID : {}" , id);

		return this.es.get(id);
	}
	
	@PostMapping(value = "/employee")    //(SAVE)
	public EmployeeResponDto saveEmployee(@RequestBody EmployeeReqDto req) {
//		String correlandId=UUID.randomUUID().toString();
//         req.setToken(UUID.randomUUID().toString());
		log.info("employee save request  : {} the user fullname : {}   " , req,req.getName());
		return ((EmployeeServies) this.es).saveEmployee(req);
	  
	}
	
	@PostMapping(value = "/employee",params = "v=1.1.0")  //(SAVE)
	public EmployeeResponDto saveEmployee11(@RequestBody EmployeeReqDto req) {
		return this.es.saveEmployee11(req);
	  
	}
	
	@GetMapping( value = "/employee")  
	public String getdetilesEmployeebyid(@RequestParam(name = "id") long id) {
		log.info("employee with id  : {}" , id);
		return this.employeeuntitiy.getdetilesEmployeebyid(id);
	}
	@PutMapping( value = "/employee")   //(UPDATE)
	public EmployeeResponDto updateEmployee(@RequestBody EmployeeupdateDto req) throws Exception {
		return this.es.updateEmployee(req);
	  
	}
	@DeleteMapping( value = "employee") // (DELETE)
	public void deleteemployeebyid( @RequestParam(name = "id") long id) {
		this.es.deleteemployeebyid(id);
		
	}

	
	
	
	

}
