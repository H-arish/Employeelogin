package com.niit.MainProject1.EmpTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.MainProject1.Config.DBConfig;
import com.niit.MainProject1.Model.Employee;
import com.niit.MainProject1.Service.EmpService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=DBConfig.class)

public class EmployeeTest {
	@Autowired
	private EmpService empService;
	Employee emp;
    @Before
    public void setUp() throws Exception
    {
    	emp=new Employee();
    	emp.setEmpId(99);
    	emp.setEname("kjj");
    	emp.setEmail("civil@gmail.com");
    	emp.setPhone("7777");
    }
    @After
    public void tearDown() throws Exception
    {
    	emp=null;
    }
   // @Ignore
    @Test
    public void addEmployee()
    {
    	assertEquals(true,empService.addEmployee(emp));
    }
    @Test
  @Ignore
    public void listEmployee()
    {
    	List<Employee> listemp=empService.getEmployeeList();
    	assertNotNull("Problem in listing Employee:",empService.getEmployeeList());
    	for(Employee emp:listemp)
    	{
    		System.out.println(emp.getEmpId()+":::"+emp.getEname()+":::"+emp.getEmail()+":::"+emp.getPhone());
    	}
    }
   @Ignore
    @Test
    public void updateEmployee()
    {
    	assertEquals(true,empService.updateEmployee(emp));
    }
   @Ignore
    @Test
    public void deleteEmployee()
    {
    	int empId=78;
    	assertEquals(true,empService.deleteEmployee(empId));
    }
}