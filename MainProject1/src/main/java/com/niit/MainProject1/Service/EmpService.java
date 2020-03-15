package com.niit.MainProject1.Service;

import java.util.List;

import com.niit.MainProject1.Model.Employee;

public interface EmpService {
	public List<Employee> getEmployeeList();
	public Employee getEmployee(int empId);
	public boolean addEmployee(Employee emp);
	public boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(int empId);
    public Employee findById(int empId);

}
