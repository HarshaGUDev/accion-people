package com.accionlabs.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accionlabs.data.EmployeeBasicDetails;
import com.accionlabs.data.EmployeeDetails;

import com.accionlabs.data.EmployeeProjectOrg;
import com.accionlabs.data.MinDetails;
import com.accionlabs.data.ProjectAndReporting;

import com.accionlabs.repositories.EmployeeRepository;
import com.accionlabs.services.EmpProjectWiseComarator;
import com.accionlabs.services.EmployeeService;

import org.apache.log4j.Logger;

@Controller
public class EmployeeDetailsController {
	final static Logger logger = Logger.getLogger(EmployeeDetailsController.class);
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeBasicDetails employeeBasicDetails;
	EmployeeDetails employeeDetails;
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/people")
	public String welcome() {
		return "index";
	}

	@ResponseBody
	@RequestMapping("/accionlabs/search/{search}")
	public List search(@PathVariable("search") String search) {
		logger.info(" Fetching the info of name include :" + search);
		return employeeRepository.getName(search);
	}

	@ResponseBody
	@RequestMapping("/accionlabs/emp/fulldetails/{employee_id}")
	public EmployeeDetails getFullDetails(@PathVariable("employee_id") String employee_id) {
		logger.info(" Fetching the full info of :" + employee_id);
		String empId = employee_id + ".0";
		return employeeRepository.getFullDetails(empId);
	}

	@ResponseBody
	@RequestMapping(value = "/accionlabs/emp/details/{employee_id}")
	public EmployeeBasicDetails getDetails(@PathVariable("employee_id") String employee_id) {
		logger.info(" Fetching the basic info of :" + employee_id);
		String empId = employeeService.idFormat(employee_id);
		EmployeeBasicDetails employeeBasicDetails = employeeService.empBasicDetails(empId);
		return employeeBasicDetails;
	}

	@ResponseBody
	@RequestMapping("/accionlabs/emp/details/{employee_id}/project")
	public Object getProjectDetails1(@PathVariable("employee_id") String employee_id) {
		logger.info(" Fetching the projectwise info of :" + employee_id);
		Set<String> noReportingMgr = new HashSet<>();
		Set<String> NoMgrReporties = new HashSet<>();

		Set listOfManagers = new HashSet();
		List<EmployeeDetails> details = null;
		String empId = employeeService.idFormat(employee_id);
		List projectWiseBasicDetails = new ArrayList<>();
		String project = employeeRepository.getProjectID(employee_id);
		List<String> getManagerList = new ArrayList<>();
		getManagerList = employeeRepository.getProjectManagersList(project);
		noReportingMgr.addAll(employeeRepository.getNoManagersList(project));
		for (String noMgr : noReportingMgr) {
			for (String noReorties : employeeRepository.getReporties(project)) {
				if (noMgr.equals(noReorties.replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2"))) {
					NoMgrReporties.add(noMgr);
				}
			}
		}
		List<String> removeZero = new ArrayList<String>();
		Set<String> fullHigherOrderList = new HashSet<String>();
		Set<String> managingDirector = new HashSet<String>();
		int count = 0;
		for (Object listofManager : getManagerList) {
			if ((String) listofManager != null) {
				empId = employeeService.idFormat(listofManager.toString());
				String mgr = employeeRepository.getProjectManagersList1(empId);
				if (mgr == null) {
					count++;
					managingDirector.add(empId.replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2"));
				}
				if (mgr != null) {
					listOfManagers.add(mgr);
				}
			}
		}
		if (count < 2) {
			if (listOfManagers.isEmpty()) {
				listOfManagers.add(empId.replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2"));
			} 
				for (Object list : listOfManagers) {
					removeZero = employeeRepository.getOrgListLowerEmpId(list.toString(), project);
					for (String id : removeZero) {
						fullHigherOrderList.add(id.replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2"));
					}
					for (Object listofManager : getManagerList) {
						if (listofManager != null) {
							empId = employeeService.idFormat(listofManager.toString());
							if (list.toString().equals(employeeRepository.getManagerByID(empId))) {
								fullHigherOrderList.add(listofManager.toString());
							}
						}
					}
				}
			
			List<MinDetails> managerDetails = new ArrayList<>();
			for (Object completeList : fullHigherOrderList) {
				empId = employeeService.idFormat(completeList.toString());
				managerDetails.add(employeeRepository.getMinDetails(empId));
			}
			EmployeeProjectOrg employeeProjectOrg = new EmployeeProjectOrg();
			for (Object list : listOfManagers) {
				empId = employeeService.idFormat(list.toString());
				employeeProjectOrg.setMinDetails(employeeRepository.getMinDetails(empId));
			}
			for (Object list : NoMgrReporties) {
				empId = employeeService.idFormat(list.toString());
				employeeProjectOrg.setNoReporties(employeeRepository.getMinDetails(empId));
			}
			for (MinDetails min : managerDetails) {
				EmployeeProjectOrg epo = new EmployeeProjectOrg();
				epo.setMinDetails(min);
				employeeProjectOrg.addProjectEmp(epo);
				List<MinDetails> subDetails = employeeRepository
						.getMinDetailsList(min.getEmployee_id().replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2"), project);
				for (MinDetails esd : subDetails) {
					EmployeeProjectOrg sepo = new EmployeeProjectOrg();
					sepo.setMinDetails(esd);
					epo.addProjectEmp(sepo);
				}
				Collections.sort(employeeProjectOrg.getListOfProjectEmp(), new EmpProjectWiseComarator());
			}
			return employeeProjectOrg;
		} else {
			List<EmployeeProjectOrg> completeDetails = new ArrayList();
			for (String s : managingDirector) {
				List<String> fullHigherOrderListOfMd = new ArrayList<>();
				List<String> listOfManagersMd = new ArrayList<>();
				listOfManagersMd.add(s);
				removeZero = employeeRepository.getOrgListLowerEmpId(s.toString(), project);
				for (String id : removeZero) {
					fullHigherOrderListOfMd.add(id.replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2"));
					getManagerList = employeeRepository.getProjectManagersList(project);
					for (String reportToMD : getManagerList) {
						empId = employeeService.idFormat(reportToMD.toString());
						if (s.toString().equals(employeeRepository.getOrgListHigherId(empId))) {
							fullHigherOrderListOfMd.add(empId.replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2"));
						}
					}
				}
				List<MinDetails> managerDetails = new ArrayList<>();
				for (Object completeList : fullHigherOrderListOfMd) {
					empId = employeeService.idFormat(completeList.toString());
					managerDetails.add(employeeRepository.getMinDetails(empId));
				}
				EmployeeProjectOrg employeeProjectOrg = new EmployeeProjectOrg();
				for (Object list : listOfManagersMd) {
					empId = employeeService.idFormat(list.toString());
					employeeProjectOrg.setMinDetails(employeeRepository.getMinDetails(empId));
				}
				for (MinDetails min : managerDetails) {
					EmployeeProjectOrg epo = new EmployeeProjectOrg();
					epo.setMinDetails(min);
					employeeProjectOrg.addProjectEmp(epo);
					List<MinDetails> subDetails = employeeRepository.getMinDetailsList(
							min.getEmployee_id().replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2"), project);
					for (MinDetails esd : subDetails) {
						EmployeeProjectOrg sepo = new EmployeeProjectOrg();
						sepo.setMinDetails(esd);
						epo.addProjectEmp(sepo);
					}
					Collections.sort(employeeProjectOrg.getListOfProjectEmp(), new EmpProjectWiseComarator());
				}
				completeDetails.add(employeeProjectOrg);
			}
			return completeDetails;
		}
	}

	@ResponseBody
	@RequestMapping("/accionlabs/emp/details/{employee_id}/manager")
	public List getReportingToDetails(@PathVariable("employee_id") String employee_id) {
		logger.info(" Fetching the managerwise info of :" + employee_id);
		String reporting_to_by_id = employeeRepository.getManagerByID(employee_id);
		List projectWiseBasicDetails = new ArrayList<>();
		projectWiseBasicDetails.add(employeeService.getProjectWiseDetails(reporting_to_by_id));
		return projectWiseBasicDetails;
	}

	@ResponseBody
	@RequestMapping("/accionlabs/emp/details/{employee_id}/designation")
	public List getOrgStructure(@PathVariable("employee_id") String employee_id) {
		logger.info(" Fetching the designation info of :" + employee_id);
		String empId = null;
		String empId2 = null;
		List orgList = new ArrayList<>();
		String higherOrderList = employeeRepository.getOrgListHigherId(employee_id);
		empId = employeeService.idFormat(higherOrderList);
		orgList.add(employeeRepository.getOrgListHigherInfo(empId));
		if (employee_id.contains(".")) {
			empId2 = employee_id.substring(0, employee_id.indexOf("."));
		} else {
			empId2 = employee_id;
		}
		orgList.add(employeeService.getProjectWiseDetails(empId2));
		return orgList;
	}
}
