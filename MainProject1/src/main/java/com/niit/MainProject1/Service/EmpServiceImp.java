package com.niit.MainProject1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MainProject1.Dao.EmpDao;
import com.niit.MainProject1.Model.Employee;
@Service
@Repository("empService")
@Transactional


public class EmpServiceImp implements EmpService{
	@Autowired
	private EmpDao empDao;

	@Override
	public List<Employee> getEmployeeList()
	{
		System.out.println("Service List");
		return empDao.getEmployeeList();
	}

	@Override
	public Employee getEmployee(int empId)
	{
		System.out.println("Service getEmp");
		return empDao.getEmployee(empId);
	}

	@Override
	public Employee findById(int empId)
	{
		return empDao.findById(empId);
	}

	@Override
	public boolean addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		System.out.println("Service addEmp");
		empDao.addEmployee(emp);
		return true;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		System.out.println("Service updateEmp");
		empDao.updateEmployee(emp);
		return true;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		System.out.println("Service Dialect");
		System.out.println(empId);
		empDao.deleteEmployee(empId);
		return true;
	}
}



	

