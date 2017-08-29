package com.accionlabs.data;

import org.springframework.stereotype.Component;

@Component
public class MinDetails {

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getDesignation_name() {
		return designation_name;
	}

	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getReporting_to_by_id() {
		return reporting_to_by_id;
	}

	public void setReporting_to_by_id(String reporting_to_by_id) {
		this.reporting_to_by_id = reporting_to_by_id;
	}

	private String employee_id;
	private String employee_name;
	private String designation_name;
	private String project;
	private String reporting_to_by_id;
	private String email_Id;
	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public MinDetails(String employee_id, String employee_name, String designation_name, String project,
			String reporting_to_by_id,String email_Id) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.designation_name = designation_name;
		this.project = project;
		this.reporting_to_by_id = reporting_to_by_id;
		this.email_Id=email_Id;
	}

	public MinDetails() {
		super();
	}

}
