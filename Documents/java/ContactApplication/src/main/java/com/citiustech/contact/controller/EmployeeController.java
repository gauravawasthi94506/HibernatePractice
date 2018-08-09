package com.citiustech.contact.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.contact.model.Employee;
import com.citiustech.contact.service.EmployeeDAO;



@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	// to save an employee
	
	@RequestMapping(value="/employees" , method=RequestMethod.POST)
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);
	}
	
	
	/*@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);
	}*/
	//get all employees
	
	@RequestMapping(value="/employees" , method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	
	//get employee by empid
	@RequestMapping(value="/employees/{id}" , method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		
		if(emp==null) {
			return new ResponseEntity(false,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(emp,HttpStatus.OK);
		
	}
	
	
	//update an employee by empid
	@RequestMapping(value="/employees/{id}" , method=RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Employee empDetails){
		
		Employee emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		
		Employee updateEmployee=employeeDAO.save(emp);
		return new ResponseEntity(updateEmployee,HttpStatus.OK);
			
		
	}
	
	//Delete an employee
	@RequestMapping(value="/employees/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return new ResponseEntity(false,HttpStatus.NOT_FOUND);
		}
		employeeDAO.delete(emp);
		
		return new ResponseEntity(emp,HttpStatus.OK);
		
		
	}
	
	

}


/*public class EmployeeController {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
//	 to save an employee
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);
	}
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	
	//get employee by empid
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	
	//update an employee by empid
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Employee empDetails){
		
		Employee emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		
		Employee updateEmployee=employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
		
		
	}
	
	//Delete an employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}
*/