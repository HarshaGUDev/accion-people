package com.accionlabs.services;

import java.util.Comparator;
import java.util.List;

import com.accionlabs.data.EmpProjectDetails;
import com.accionlabs.data.EmployeeDetails;
import com.accionlabs.data.ProjectAndReporting;

class EmpManagerWiseComparator implements Comparator<EmpProjectDetails> {

	@Override
	public int compare(EmpProjectDetails o1, EmpProjectDetails o2) {
		return Integer.valueOf(o2.getEmpProjectList().size()).compareTo(o1.getEmpProjectList().size());
	}
}
