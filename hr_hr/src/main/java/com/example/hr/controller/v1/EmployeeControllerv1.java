package com.example.hr.controller.v1;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hr.model.Dto.EmployeeResponDto;
import com.example.hr.model.Dto.v1.EmployeeReqDtov1;
import com.example.hr.servies.v1.EmployeeServisv1;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;



@RestController

@RequestMapping("/employees/v1")
//  Constructor  دي بدل Autowired  واسهل بتعمل 
@RequiredArgsConstructor    


public class EmployeeControllerv1 {
	

	private  final  EmployeeServisv1 employeeServisv1 ;

	

	
	@PostMapping(value = "/employee")   //(SAVE)
	public EmployeeResponDto saveEmployee(@RequestBody @Valid EmployeeReqDtov1 req) {
		return this.employeeServisv1.saveEmployee1(req);
	  
	}
	
	

	
	

}
