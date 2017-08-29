package com.accionlabs.services;

import java.util.Comparator;

import com.accionlabs.data.EmployeeProjectOrg;
import com.accionlabs.data.ProjectAndReporting;

public class EmpProjectWiseComparator implements Comparator<EmployeeProjectOrg> {

	public int compare(EmployeeProjectOrg o1, EmployeeProjectOrg o2) {
		return Integer.valueOf(o2.getListOfProjectEmp().size()).compareTo(o1.getListOfProjectEmp().size());
	}

}
