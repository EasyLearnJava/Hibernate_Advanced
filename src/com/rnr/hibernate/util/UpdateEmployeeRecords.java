package com.rnr.hibernate.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rnr.hibernate.dto.Address;
import com.rnr.hibernate.dto.Employee;

public class UpdateEmployeeRecords {
public static void main(String[] args) {		
			
		Session session = HibernateUtil.getSession();
		
		//Update an existing employee details
		updateAddressRecord(session, 4, "CCA"); 
		
		//Update an existing employee details
		updateEmployeeRecord(session, 3, "xyz"); 
				
	}

	
	//UPDATE
	private static void updateEmployeeRecord(Session session, Integer employeeId, String empLogin){
		
		Transaction tx = null;
		try{
			Employee employeeDetails = (Employee)session.get(Employee.class, employeeId);
			if(employeeDetails != null){
				employeeDetails.setLoginName(empLogin);
				tx = session.beginTransaction();
				session.saveOrUpdate(employeeDetails);
				tx.commit();
			}
		}catch(Exception e){
			e.printStackTrace();
			if(null != tx){
				tx.rollback();
			}
		}
	}
	
	
	//UPDATE
	private static void updateAddressRecord(Session session, Integer addressId, String state){
		
		Transaction tx = null;
		try{
			Address addressDetails = (Address)session.get(Address.class, addressId);
			if(addressDetails != null){
				addressDetails.setState(state);
				tx = session.beginTransaction();
				session.saveOrUpdate(addressDetails);
				tx.commit();
			}
		}catch(Exception e){
			e.printStackTrace();
			if(null != tx){
				tx.rollback();
			}
		}
	}
	
}
