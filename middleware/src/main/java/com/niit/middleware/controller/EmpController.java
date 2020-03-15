package com.niit.middleware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.MainProject1.Model.Employee;
import com.niit.MainProject1.Service.EmpService;

@RestController
@RequestMapping("/api/emp")
@CrossOrigin(origins="http://localhost:4200")

public class EmpController {
		
	@Autowired
	private EmpService empService;
	
	@GetMapping
	public List<Employee> listAllEmployee()
	{	System.out.println("C-List--method");

		List<Employee> emp = empService.getEmployeeList();
		return emp;
	}
	
	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody Employee emp)
	{
		System.out.println("C-ADD_Employee");

		if(empService.getEmployee(emp.getEmpId())==null)
		{
			empService.addEmployee(emp);
			System.out.println("Inside postmapping");
			return new ResponseEntity<Void>(HttpStatus.CREATED);
			
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee emp)
	{
		System.out.println("C-UpDaTe");

		if(empService.getEmployee(emp.getEmpId())!=null)
		{
			empService.updateEmployee(emp);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteFact(@PathVariable("empId") int empId)
	{
	if(empService.getEmployee(empId)!=null) {
		empService.deleteEmployee(empId);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
	else 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getById(@PathVariable("empId") int empId)
	{
		//Fact fact = null;
		//return new ResponseEntity<Fact>(factService.getFact(factId),HttpStatus.OK);
		if(empService.getEmployee(empId) != null) {
			return new ResponseEntity<Employee> (empService.getEmployee(empId), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Employee> (HttpStatus.NOT_FOUND);
		}
	}
	

}