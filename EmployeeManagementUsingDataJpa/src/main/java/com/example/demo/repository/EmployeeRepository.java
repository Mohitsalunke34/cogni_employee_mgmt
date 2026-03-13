package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	// persit(),merge(),find() --> 1 row operation
	// createQuery() -->for multi row operation
	
	@Query("select e from Employee e where e.empDesg=?1")
	public abstract List<Employee> getEmployeeByDesg(String empDesg); //

	
	@Query("select e from Employee e where e.empSal between :min and :max")
	List<Employee> getEmployeesBetweenSal( @Param("min") int initialSal,
			@Param("max") int finalSal);


}


//Repository
//CrudRepository
//JpaRepository
