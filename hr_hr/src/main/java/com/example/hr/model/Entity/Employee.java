package com.example.hr.model.Entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hr")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "username")
	private String name;
	@Column(name = "full_name")
	private String fullname;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	
////	private String token;
//
	@CreationTimestamp
	@Column(name = "created-at")
	private LocalDateTime creatAt;
////	دي بتخلي يضيف الوقت اتوماتيك 
	 
//	
	@UpdateTimestamp
	@Column(name = "update-at")

	private LocalDateTime updateAt;
//	@Column(name = "delete_At")
//	private LocalDateTime deleteAt;
	

}
