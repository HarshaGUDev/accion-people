package com.accionlabs.data;

import java.util.ArrayList;
import java.util.List;

public class ProjectAndReporting {
	public String getReportingId() {
		return reportingId;
	}

	public void setReportingId(String reportingId) {
		this.reportingId = reportingId;
	}

	public List getEmpProjectList() {
		return empProjectList;
	}

	public void setEmpProjectList(List empProjectList) {
		this.empProjectList = empProjectList;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	private String employee_name;
	private String designation_name;

	public String getDesignation_name() {
		return designation_name;
	}

	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}

	private String reportingId;
	List empProjectList = new ArrayList<>();

}
