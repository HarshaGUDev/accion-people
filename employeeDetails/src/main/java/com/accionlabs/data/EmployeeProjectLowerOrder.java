package com.accionlabs.data;

import java.util.ArrayList;
import java.util.List;

public class EmployeeProjectLowerOrder {
	EmployeeDetails employeeDetails;
	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}
	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	public List<EmployeeDetails> getListOfProjectEmp() {
		return listOfProjectEmp;
	}
	public void setListOfProjectEmp(List<EmployeeDetails> listOfProjectEmp) {
		this.listOfProjectEmp = listOfProjectEmp;
	}
	List listOfProjectEmp=new ArrayList();

}
