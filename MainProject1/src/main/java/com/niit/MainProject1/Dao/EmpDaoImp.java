package com.niit.MainProject1.Dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MainProject1.Model.Employee;



@Repository("empDao")
@Transactional
public class EmpDaoImp implements EmpDao {

@Autowired
 private SessionFactory sessionFactory;

@Override
public List<Employee> getEmployeeList()
{
	return sessionFactory.getCurrentSession().createQuery("from Employee").list();
}

@Override
public Employee getEmployee(int empId)
{
	return (Employee)sessionFactory.getCurrentSession().createQuery("from Employee where empId="+empId).uniqueResult();
}

@Override
public boolean addEmployee(Employee emp)
{
 try
 {
	 sessionFactory.getCurrentSession().save(emp);
	 return true;
 }
 catch(Exception e)
 {
	 return false;
 }
}
@Override
public boolean updateEmployee(Employee emp)
{
	try
	{
		sessionFactory.getCurrentSession().update(emp);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
}
@Override
public Employee findById(int empId)
{
	System.out.println(empId);
	return(Employee)sessionFactory.getCurrentSession().createQuery("from Employee where empId="+empId).uniqueResult();
}
public boolean deleteEmployee(int empId)
{
	try
	{
		System.out.println("Inside DAO deleteEmployee");
		sessionFactory.getCurrentSession().delete(findById(empId));
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
}
}
