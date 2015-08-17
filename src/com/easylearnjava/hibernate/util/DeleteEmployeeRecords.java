package com.easylearnjava.hibernate.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.easylearnjava.hibernate.dto.Address;
import com.easylearnjava.hibernate.dto.Employee;

public class DeleteEmployeeRecords {
public static void main(String[] args) {		
			
		Session session = HibernateUtil.getSession();
		
		//Delete address record
		deleteEmployeeAddressRecord(session, 5);
		
		//Delete an employee
		deleteEmployeeRecord(session, 3);
				
	}

	//DELETE	
	private static void deleteEmployeeRecord(Session session, Integer employeeId){
		
		Employee employee = (Employee)session.get(Employee.class, employeeId);
		if(employee != null){	    
			Transaction tx = session.beginTransaction();
			session.delete(employee);
			tx.commit();
		}
	}
	
	//DELETE	
	private static void deleteEmployeeAddressRecord(Session session, Integer addressId){
		
		Address address = (Address)session.get(Address.class, addressId);
		if(address != null){	    
			Transaction tx = session.beginTransaction();
			session.delete(address);
			tx.commit();
		}
	}
	
}
