package com.accionlabs.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accionlabs.data.EmpProjectDetails;
import com.accionlabs.data.EmployeeBasicDetails;
import com.accionlabs.data.EmployeeDetails;
import com.accionlabs.data.MinDetails;
import com.accionlabs.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	

	public EmployeeBasicDetails empBasicDetails(String name) {
		EmployeeDetails empDetails = employeeRepository.getDetails(name);
		EmployeeBasicDetails fliteredDetails = filterEmpDetails(empDetails);
		return fliteredDetails;
	}

	public EmployeeBasicDetails filterEmpDetails(EmployeeDetails empDetails) {
		EmployeeBasicDetails employeeBasicDetails = new EmployeeBasicDetails();
		if(empDetails!=null){
		employeeBasicDetails.setEmployee_id(empDetails.getEmployee_id());
		employeeBasicDetails.setEmployee_name(empDetails.getEmployee_name());
		employeeBasicDetails.setEmail_Id(empDetails.getEmail_Id());
		employeeBasicDetails.setReporting_to(empDetails.getReporting_to());
		employeeBasicDetails.setDesignation_name(empDetails.getDesignation_name());
		employeeBasicDetails.setDepartment_name(empDetails.getDepartment_name());
		employeeBasicDetails.setAddress1(empDetails.getAddress1());
		employeeBasicDetails.setWork_mobile_number(empDetails.getWork_mobile_number());
		employeeBasicDetails.setLocation(empDetails.getLocation());
		employeeBasicDetails.setProject(empDetails.getProject());
		employeeBasicDetails.setReporting_to_by_id(empDetails.getReporting_to_by_id());
		employeeBasicDetails.setImage(empDetails.getImage());
		employeeBasicDetails.setDate_of_joining(empDetails.getDate_of_joining());
		}
		return employeeBasicDetails;
			// TODO Auto-generated method stub
	}

	public List<EmpProjectDetails> getProjectWiseDetails(String empid) {
		List<String> listOfProject = employeeRepository.getOrgListLower(empid);

		List<EmpProjectDetails> listOfDetails = new ArrayList<>();
		
		for (String projectByDetails : listOfProject) {
			List listOfDetailsProjectWise = new ArrayList<>();
			EmpProjectDetails empProjectDetails = new EmpProjectDetails();
			empProjectDetails.setProject(projectByDetails);
			List<EmployeeDetails> lowerEmpDetialsList=employeeRepository.getOrgListLower1(empid, projectByDetails);
			for(EmployeeDetails lowerEmpDetials:lowerEmpDetialsList){
				EmployeeBasicDetails employeeBasicDetails=filterEmpDetails(lowerEmpDetials);
				listOfDetailsProjectWise.add(employeeBasicDetails);
				
			}
	empProjectDetails.setEmpProjectList( listOfDetailsProjectWise);
		
			listOfDetails.add(empProjectDetails);
			
		}
		Collections.sort(listOfDetails, new EmpManagerWiseComarator());

		return listOfDetails;

	}


	public List getProjectWiseAndMangerWiseDetails(String empid, String project) {
		EmployeeBasicDetails fliteredDetails = null;
	
		List<EmployeeDetails> listOfProject = employeeRepository.getProjectAndManagerWiseDetails(empid, project);

		List listOfDetails = new ArrayList<>();
				for (EmployeeDetails projectByDetails : listOfProject) {			
			fliteredDetails = filterEmpDetails(projectByDetails);
			listOfDetails.add(fliteredDetails);
		}

		return listOfDetails;

	}
	public String idFormat(String id){
		
		String empId =null;
		if(id!=null){
		if(id.startsWith("1")){
			 empId = id + ".0";	
		}
		else {
			 empId = id;	
		}	}	
		return empId;
		
	}
	
	public MinDetails getMinDetails(String empid){
		MinDetails minDetails=new MinDetails();
		minDetails.setEmployee_id(empid);
		minDetails.setDesignation_name(employeeRepository.getmanagerDesignation(empid));
		minDetails.setReporting_to_by_id(employeeRepository.getManagerByID(empid));
		minDetails.setEmployee_name(employeeRepository.getmanagerName(empid));
		minDetails.setProject(employeeRepository.getProjectID(empid));
		return minDetails;
		
	}
List<String> subDetails=new ArrayList<>();
List<MinDetails> fullDetails=null;
	public List<MinDetails> getMinDetailsOfAllEmp(String removeZero, String project) {
System.out.println(project);
		subDetails= employeeRepository.getOrgListLowerEmpId(removeZero, project);
		if(subDetails!=null){
		for(String empId:subDetails){
			fullDetails.add(getMinDetails(empId));
		}}
		return fullDetails;
	}
}
