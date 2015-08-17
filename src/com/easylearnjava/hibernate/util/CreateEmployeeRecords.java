package com.easylearnjava.hibernate.util;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.easylearnjava.hibernate.dto.Address;
import com.easylearnjava.hibernate.dto.Employee;

public class CreateEmployeeRecords {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		//Employee 1 record.
		// Create an Employee and Address Records and save to database
		Address firstAddress = new Address();
		firstAddress.setStreetOne("1122 Abc Rd");
		firstAddress.setStreetTwo("345");
		firstAddress.setCity("Irving");
		firstAddress.setState("TX");
		firstAddress.setZip("23456");

		Address SecondAddress = new Address();
		SecondAddress.setStreetOne("2233 globe st");
		SecondAddress.setStreetTwo("8799");
		SecondAddress.setCity("Plano");
		SecondAddress.setState("FL");
		SecondAddress.setZip("87999");

		Set<Address> addressSet = new HashSet<Address>();
		addressSet.add(firstAddress);
		addressSet.add(SecondAddress);

		Employee newEmployee = new Employee();
		newEmployee.setLoginName("raghu");
		newEmployee.setLoginPassword("secret");
		newEmployee.setAddresses(addressSet);

		firstAddress.setEmployee(newEmployee);
		SecondAddress.setEmployee(newEmployee);

		saveEmployeeDetails(session, newEmployee);
		
		//Employee 2 records
		// Create an Employee and Address Records and save to database
		firstAddress = new Address();
		firstAddress.setStreetOne("6324 Belt Line");
		firstAddress.setStreetTwo("7666");
		firstAddress.setCity("Tampa");
		firstAddress.setState("FL");
		firstAddress.setZip("43447");

		addressSet = new HashSet<Address>();
		addressSet.add(firstAddress);
		
		newEmployee = new Employee();
		newEmployee.setLoginName("naveen");
		newEmployee.setLoginPassword("topsecret");
		newEmployee.setAddresses(addressSet);

		firstAddress.setEmployee(newEmployee);
		
		saveEmployeeDetails(session, newEmployee);
		
		//Employee 3 records
		//Create an Employee and Address Records and save to database		
		firstAddress = new Address();
		firstAddress.setStreetOne("876 Jersey Dr");
		firstAddress.setStreetTwo("54");
		firstAddress.setCity("Denton");
		firstAddress.setState("NY");
		firstAddress.setZip("22980");

		SecondAddress = new Address();
		SecondAddress.setStreetOne("9012 GoldenGate");
		SecondAddress.setStreetTwo("3430");
		SecondAddress.setCity("Euelss");
		SecondAddress.setState("NC");
		SecondAddress.setZip("23220");

		addressSet = new HashSet<Address>();
		addressSet.add(firstAddress);
		addressSet.add(SecondAddress);

		newEmployee = new Employee();
		newEmployee.setLoginName("ramu");
		newEmployee.setLoginPassword("rockingsecret");
		newEmployee.setAddresses(addressSet);

		firstAddress.setEmployee(newEmployee);
		SecondAddress.setEmployee(newEmployee);

		saveEmployeeDetails(session, newEmployee);
	}

	public static void createEmployee(Session session, String empLoginName,
			String empLoginPassword) {

		Transaction tx = null;
		try {
			Employee newEmployeeObj = new Employee(empLoginName,
					empLoginPassword);
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(newEmployeeObj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (null != tx) {
				tx.rollback();
			}
		}
	}

	// CREATE Employee and Address Records
	private static void saveEmployeeDetails(Session session, Employee employee) {

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Integer employeeId = (Integer) session.save(employee);
			System.out.println("New Employee Id : " + employeeId);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (null != tx) {
				tx.rollback();
			}
		}
	}

}
