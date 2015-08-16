package com.rnr.hibernate.util;

import java.util.List;

import org.hibernate.Session;

import com.rnr.hibernate.dto.Employee;

public class ReadEmployeeRecords extends BaseDao{
public static void main(String[] args) {		
		
		Session session = HibernateUtil.getSession();		
		
		getAllEmployeeDetails(session);
		getEmployeeDetailsById(session, 3);
	}


	//READ
	@SuppressWarnings("unchecked")
	private static void getAllEmployeeDetails(Session session) {
		
		List<Employee> employees = session.createQuery("from Employee").list();		
		printEmployeeDetails(employees);
	}
	
	
	//READ
	private static void getEmployeeDetailsById(Session session, Integer employeeId){
		
		//Employee employee = (Employee)session.load(Employee.class, employeeId);
		Employee employee = (Employee)session.get(Employee.class, employeeId);
		printEmployeeDetails(employee);
	}	

}
