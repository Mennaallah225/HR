package com.example.hr.model.Dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data 
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {
	private long id;
	private String username;
	private String full_name;
	private String password;
	private String email;
	private LocalDateTime createdAt;
	private LocalDateTime updateAt;
	private LocalDateTime deleteAt;
	

}
