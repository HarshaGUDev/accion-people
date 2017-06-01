package com.accionlabs.data;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
public class EmployeeBasicDetails {
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

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public String getReporting_to() {
		return reporting_to;
	}

	public void setReporting_to(String reporting_to) {
		this.reporting_to = reporting_to;
	}

	public String getDesignation_name() {
		return designation_name;
	}

	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public double getWork_mobile_number() {
		return work_mobile_number;
	}

	public void setWork_mobile_number(double d) {
		this.work_mobile_number = d;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	@Lob
	private byte[] image;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] bs) {
		this.image = bs;
	}

	@Id
	private String employee_id;
	private String employee_name;
	private String email_Id;
	private String reporting_to;
	private String designation_name;
	private String department_name;
	private String address1;
	private double work_mobile_number;
	private String location;
	private String project;
	private String reporting_to_by_id;
	private String date_of_joining;

}
