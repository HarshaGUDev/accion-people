package com.accionlabs.data;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "employeedetails ")
public class EmployeeDetails {
	@Id
	private String employee_id;
	private String employee_name;
	private String first_name;
	private String last_name;
	private String middle_name;
	private String salutation;
	private String email_Id;
	private String reporting_to;
	private String functional_reporting_to;
	private String ou_name;
	private String designation_name;
	private String grade_name;
	private String department_name;
	private String position;
	private String employment_status;
	private String employee_status;
	private String employment_type;
	private String date_of_joining;
	private String confirmation_date;
	private String confirmation_due_date;
	private String contract_end_date;
	private double age;
	private String date_of_birth;;
	private String gender;
	private String address1;
	private String address2;
	private String current_city;
	private String current_state;
	private String current_country;
	private double work_mobile_number;
	private double permanent_pincode;
	private String work_phone;
	private String personal_email;
	private String permanent_address1;
	private String permanent_address2;
	private String permanent_address3;
	private String permanent_city;
	private String permanent_state;
	private String permanent_country;
	private String pan_number;
	private String region;
	private String city_name;
	private String location;
	private String locationaddress;
	private String locationstate;
	private String added_on;
	private String added_by;
	private String calendar_name;
	private String relieving_date;
	private String project;
	private String pay_group;
	private String physically_challanged;
	private String disability;
	private double aadhar_no;
	private double uan_number;
	private String reporting_to_by_id;
	
	 @Lob
		private  byte[]  image;
	public byte[] getImage() {
	return image;
}

public void setImage(byte[] image) {
	this.image = image;
}

	public String getReporting_to_by_id() {
		return reporting_to_by_id;
	}

	public void setReporting_to_by_id(String reporting_to_by_id) {
		this.reporting_to_by_id = reporting_to_by_id;
	}

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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
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

	public String getFunctional_reporting_to() {
		return functional_reporting_to;
	}

	public void setFunctional_reporting_to(String functional_reporting_to) {
		this.functional_reporting_to = functional_reporting_to;
	}

	public String getOu_name() {
		return ou_name;
	}

	public void setOu_name(String ou_name) {
		this.ou_name = ou_name;
	}

	public String getDesignation_name() {
		return designation_name;
	}

	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}

	public String getGrade_name() {
		return grade_name;
	}

	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmployment_status() {
		return employment_status;
	}

	public void setEmployment_status(String employment_status) {
		this.employment_status = employment_status;
	}

	public String getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}

	public String getEmployment_type() {
		return employment_type;
	}

	public void setEmployment_type(String employment_type) {
		this.employment_type = employment_type;
	}

	public String getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public String getConfirmation_date() {
		return confirmation_date;
	}

	public void setConfirmation_date(String confirmation_date) {
		this.confirmation_date = confirmation_date;
	}

	public String getConfirmation_due_date() {
		return confirmation_due_date;
	}

	public void setConfirmation_due_date(String confirmation_due_date) {
		this.confirmation_due_date = confirmation_due_date;
	}

	public String getContract_end_date() {
		return contract_end_date;
	}

	public void setContract_end_date(String contract_end_date) {
		this.contract_end_date = contract_end_date;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double d) {
		this.age = d;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCurrent_city() {
		return current_city;
	}

	public void setCurrent_city(String current_city) {
		this.current_city = current_city;
	}

	public String getCurrent_state() {
		return current_state;
	}

	public void setCurrent_state(String current_state) {
		this.current_state = current_state;
	}

	public String getCurrent_country() {
		return current_country;
	}

	public void setCurrent_country(String current_country) {
		this.current_country = current_country;
	}

	public double getWork_mobile_number() {
		return work_mobile_number;
	}

	public void setWork_mobile_number(double d) {
		this.work_mobile_number = d;
	}

	public double getPermanent_pincode() {
		return permanent_pincode;
	}

	public void setPermanent_pincode(double d) {
		this.permanent_pincode = d;
	}

	public String getWork_phone() {
		return work_phone;
	}

	public void setWork_phone(String d) {
		this.work_phone = d;
	}

	public String getPersonal_email() {
		return personal_email;
	}

	public void setPersonal_email(String personal_email) {
		this.personal_email = personal_email;
	}

	public String getPermanent_address1() {
		return permanent_address1;
	}

	public void setPermanent_address1(String permanent_address1) {
		this.permanent_address1 = permanent_address1;
	}

	public String getPermanent_address2() {
		return permanent_address2;
	}

	public void setPermanent_address2(String permanent_address2) {
		this.permanent_address2 = permanent_address2;
	}

	public String getPermanent_address3() {
		return permanent_address3;
	}

	public void setPermanent_address3(String permanent_address3) {
		this.permanent_address3 = permanent_address3;
	}

	public String getPermanent_city() {
		return permanent_city;
	}

	public void setPermanent_city(String permanent_city) {
		this.permanent_city = permanent_city;
	}

	public String getPermanent_state() {
		return permanent_state;
	}

	public void setPermanent_state(String permanent_state) {
		this.permanent_state = permanent_state;
	}

	public String getPermanent_country() {
		return permanent_country;
	}

	public void setPermanent_country(String permanent_country) {
		this.permanent_country = permanent_country;
	}

	public String getPan_number() {
		return pan_number;
	}

	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationaddress() {
		return locationaddress;
	}

	public void setLocationaddress(String locationaddress) {
		this.locationaddress = locationaddress;
	}

	public String getLocationstate() {
		return locationstate;
	}

	public void setLocationstate(String locationstate) {
		this.locationstate = locationstate;
	}

	public String getAdded_on() {
		return added_on;
	}

	public void setAdded_on(String added_on) {
		this.added_on = added_on;
	}

	public String getAdded_by() {
		return added_by;
	}

	public void setAdded_by(String d) {
		this.added_by = d;
	}

	public String getCalendar_name() {
		return calendar_name;
	}

	public void setCalendar_name(String calendar_name) {
		this.calendar_name = calendar_name;
	}

	public String getRelieving_date() {
		return relieving_date;
	}

	public void setRelieving_date(String relieving_date) {
		this.relieving_date = relieving_date;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getPay_group() {
		return pay_group;
	}

	public void setPay_group(String pay_group) {
		this.pay_group = pay_group;
	}

	public String getPhysically_challanged() {
		return physically_challanged;
	}

	public void setPhysically_challanged(String physically_challanged) {
		this.physically_challanged = physically_challanged;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public double getAadhar_no() {
		return aadhar_no;
	}

	public void setAadhar_no(double aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public double getUan_number() {
		return uan_number;
	}

	public void setUan_number(double d) {
		this.uan_number = d;
	}

}
