package com.example.demo.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employees") //class level url
@AllArgsConstructor
public class EmployeeController { // http://localhost:8001/employees

	
	EmployeeService service;

//	@RequestMapping(method=RequestMethod.GET,"/message")
	@GetMapping("/message") // http://localhost:8001/employees/message
	public String getMessage() {
		return "leave us we are getting sleep!!!";
	}

	@PostMapping("/save") // http://localhost:8001/employees/save
	public String createEmployee(@RequestBody @Validated Employee employee) {
		return service.saveEmployee(employee);
	}

	@PutMapping("/update") // http://localhost:8001/employees/update
	public String updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@DeleteMapping("/delete/{id}") // http://localhost:8001/employees/delete/id
	public String deleteEmployee(@PathVariable("id") int empId) {
		return service.deleteEmployee(empId);
	}

	@GetMapping("/fetch/{id}") // http://localhost:8001/employees/fetch/id
	public Employee getEmployee(@PathVariable("id") int empId) throws EmployeeNotFound {
		return service.getEmployee(empId);
	}

	@GetMapping("/fetchAll")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployees();
	}

	@GetMapping("/fetchAllByDesg/{empDesg}")
	public List<Employee> getllEmployee(@PathVariable("empDesg") String empDesg) {
		return service.getEmployeeByDesg(empDesg);
	}

	@GetMapping("/fetchAllBetweenSal")
	public List<Employee> getllEmployee(@RequestParam("min") int initialSal, @RequestParam("max") int finalSal) {
		return service.getEmployeesBetweenSal(initialSal, finalSal);
	}
}
