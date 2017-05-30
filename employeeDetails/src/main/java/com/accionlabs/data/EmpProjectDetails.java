package com.accionlabs.data;

import java.util.ArrayList;
import java.util.List;

public class EmpProjectDetails {
	private String project;

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public List getEmpProjectList() {
		return empProjectList;
	}

	public List<EmployeeDetails> setEmpProjectList(List empProjectList) {
		return this.empProjectList = empProjectList;
	}

	List empProjectList = new ArrayList<>();
}
