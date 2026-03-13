package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "cts_emp_Crud")
@Data //GETTER + SETTER + NOARGSCONSTRUCTOR + ALLARGSCONSTUCTOR + EQUALSANDHASHCODE
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@Column(name = "empno", length = 10)
	@Min(value=1, message = "Employee Id cannot be -ve")
	private int empId;

	@NotBlank(message = "Name Cannot be Empty or Blank or Null")
	@Column(name = "ename", nullable = false)
	@Size(min = 6 , max = 15,message = "Name length must be in between 6 to 15 ")
	private String empName;
	
	@Min(value = 10000,message = "Salary cannot be below 10000")
	@Max(value = 100000,message = "Salary cannot be more than 100000")
	private int empSal;
	
	@NotEmpty(message = "Designation cannot null/empty")
	private String empDesg;

}
