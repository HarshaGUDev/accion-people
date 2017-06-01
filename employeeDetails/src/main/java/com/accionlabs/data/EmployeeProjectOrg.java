package com.accionlabs.data;

import java.util.ArrayList;
import java.util.List;
import com.accionlabs.data.MinDetails;

public class EmployeeProjectOrg {
	private MinDetails minDetails;
	private List<EmployeeProjectOrg> listOfProjectEmp;
	private MinDetails noReporties;

	public MinDetails getNoReporties() {
		return noReporties;
	}

	public void setNoReporties(MinDetails noReporties) {
		this.noReporties = noReporties;
	}

	public MinDetails getMinDetails() {
		return minDetails;
	}

	public void setMinDetails(MinDetails minDetails) {
		this.minDetails = minDetails;
	}

	public List<EmployeeProjectOrg> getListOfProjectEmp() {
		if (listOfProjectEmp == null) {
			listOfProjectEmp = new ArrayList<>();
		}
		return listOfProjectEmp;
	}

	public void setListOfProjectEmp(List<EmployeeProjectOrg> listOfProjectEmp) {
		this.listOfProjectEmp = listOfProjectEmp;
	}

	public void addProjectEmp(EmployeeProjectOrg e) {
		getListOfProjectEmp().add(e);
	}

}
