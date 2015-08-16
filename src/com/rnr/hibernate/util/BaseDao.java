package com.rnr.hibernate.util;

import java.util.List;

import com.rnr.hibernate.dto.Address;
import com.rnr.hibernate.dto.Employee;

public class BaseDao {

	public static void printEmployeeDetails(List<Employee> employeeRecordsList){
		System.out.println();
		if(null != employeeRecordsList){
			System.out.println("===========" + "\t" + "==============" + "\t" + "=================");
			System.out.println("Employee Id" + "\t" + "Employee Login" + "\t" + "Employee Password");
			System.out.println("===========" + "\t" + "==============" + "\t" + "=================");
			for (Employee empObj : employeeRecordsList) {
				System.out.println(empObj.getEmployeeId() + "\t\t" + empObj.getLoginName() + "\t\t" + empObj.getLoginPassword());
			}
			System.out.println();
			System.out.println();
			System.out.println("==========" + "\t" + "==============" + "\t\t" + "========" + "\t" + "====" + "\t" + "=====" + "\t" + "===");
			System.out.println("Address Id" + "\t" + "Street Address" + "\t\t" + "House No" + "\t" + "City" + "\t" + "State" + "\t" + "Zip");
			System.out.println("==========" + "\t" + "==============" + "\t\t" + "========" + "\t" + "====" + "\t" + "=====" + "\t" + "===");
			for(Employee employee:employeeRecordsList){
				for(Address address : employee.getAddresses()){
					System.out.println(address.getAddressId() + "\t\t" + address.getStreetOne() + "\t\t" + address.getStreetTwo() + "\t\t" + address.getCity() + "\t" + address.getState() + "\t" + address.getZip());
				}
			}
		}else{
			System.out.println("==========================");
			System.out.println("Employee records not found");
			System.out.println("==========================");
		}
	}
	
	
	public static void printEmployeeDetails(Employee employeeRecord){
		System.out.println();
		if(null != employeeRecord){
			System.out.println("===========" + "\t" + "==============" + "\t" + "=================");
			System.out.println("Employee Id" + "\t" + "Employee Login" + "\t" + "Employee Password");
			System.out.println("===========" + "\t" + "==============" + "\t" + "=================");
			System.out.println(employeeRecord.getEmployeeId() + "\t\t" + employeeRecord.getLoginName() + "\t\t" + employeeRecord.getLoginPassword());
			
			System.out.println();
			System.out.println();
			System.out.println("==========" + "\t" + "==============" + "\t\t" + "========" + "\t" + "====" + "\t" + "=====" + "\t" + "===");
			System.out.println("Address Id" + "\t" + "Street Address" + "\t\t" + "House No" + "\t" + "City" + "\t" + "State" + "\t" + "Zip");
			System.out.println("==========" + "\t" + "==============" + "\t\t" + "========" + "\t" + "====" + "\t" + "=====" + "\t" + "===");
			for(Address address : employeeRecord.getAddresses()){
				System.out.println(address.getAddressId() + "\t\t" + address.getStreetOne() + "\t\t" + address.getStreetTwo() + "\t\t" + address.getCity() + "\t" + address.getState() + "\t" + address.getZip());
			}
		}else{
			System.out.println("==========================");
			System.out.println("Employee records not found");
			System.out.println("==========================");
		}
	}

}
