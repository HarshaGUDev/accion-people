package com.accionlabs.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.accionlabs.data.EmployeeDetails;
import com.accionlabs.data.MinDetails;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDetails, String> {

	@Query(" from EmployeeDetails  where employee_name like %:search%")
	public List<EmployeeDetails> getName(@Param("search") String search);

	@Query(" from EmployeeDetails where employee_id=:employee_id")
	public EmployeeDetails getFullDetails(@Param("employee_id") String employee_id);

	@Query(" from EmployeeDetails where employee_id=:employee_id")
	public EmployeeDetails getDetails(@Param("employee_id") String employee_id);

	@Query(" Select a.reporting_to_by_id from EmployeeDetails a where a.employee_id=:employee_id")
	public String getOrgListHigherId(@Param("employee_id") String employee_id);

	@Query("  from EmployeeDetails a where a.employee_id=:employee_id")
	public EmployeeDetails getOrgListHigherInfo(@Param("employee_id") String employee_id);

	@Query(" Select distinct a.project from EmployeeDetails a where a.reporting_to_by_id=:reporting_to_by_id ORDER BY project")
	public List<String> getOrgListLower(@Param("reporting_to_by_id") String reporting_to_by_id);

	@Query("  from EmployeeDetails a where a.reporting_to_by_id=:reporting_to_by_id  AND a.project=:project order by grade_name desc,employee_name ")
	public List<EmployeeDetails> getOrgListLower1(@Param("reporting_to_by_id") String reporting_to_by_id,
			@Param("project") String project);

	@Query(" Select a.project  from EmployeeDetails a where a.employee_id=:employee_id")
	public String getProjectID(@Param("employee_id") String employee_id);

	@Query(" Select distinct a.reporting_to_by_id from EmployeeDetails a where a.project=:project")
	public List<String> getProjectManagersList(@Param("project") String project);

	@Query(" Select  a  from EmployeeDetails a where a.project=:project and a.reporting_to_by_id=:empid")
	public List getProjectAndManagerWiseDetails(@Param("empid") String empid, @Param("project") String project);

	@Query(" Select a.employee_name from EmployeeDetails a where a.employee_id=:employee_id")
	public String getmanagerName(@Param("employee_id") String employee_id);

	@Query(" Select a.designation_name from EmployeeDetails a where a.employee_id=:employee_id")
	public String getmanagerDesignation(@Param("employee_id") String employee_id);

	@Query(" Select a.reporting_to_by_id  from EmployeeDetails a where a.employee_id=:employee_id")
	public String getManagerByID(@Param("employee_id") String employee_id);

	@Query("select a.employee_name from  EmployeeDetails a  where a.project  ='' ")
	public List getEmptyProjectEmp();
	
	@Query(" Select  a.reporting_to_by_id from EmployeeDetails a where a.employee_id=:empid")
	public String getProjectManagersList1(@Param("empid") String empid);
	
	@Query(" from EmployeeDetails a where a.reporting_to_by_id=:reporting_to_by_id and a.project=:project ")
	public List getOrgListLower2(@Param("reporting_to_by_id") String reporting_to_by_id,
			@Param("project") String project);
	
	@Query(" Select distinct a.reporting_to_by_id from EmployeeDetails a where a.project=:project and a.reporting_to_by_id!=:higherOrderId")
	public List<String> getReportingOrg(@Param("project") String project,@Param("higherOrderId") String higherOrderId);
	
	@Query(" Select  a.employee_id from EmployeeDetails a where a.reporting_to_by_id=:empid and a.project=:project")
	public List reportingToRamesh(@Param("empid") String empid, @Param("project")  String project);
	
	@Query(" Select a.reporting_to_by_id from EmployeeDetails a where a.employee_id=:empId")
	public String getRameshReportingId(@Param("empId") String empId);


	@Query(" Select  distinct a.employee_id from EmployeeDetails a where a.reporting_to_by_id=:empid and a.project=:project")
	public List<String> getOrgListLowerEmpId(@Param("empid") String empid, @Param("project")  String project);
	/*
	@Query("select a.employee_id as employee_id ,a.employee_name as employee_name, a.designation_name as designation_name,"
			+ "a.project as project,a.reporting_to_by_id as reporting_to_by_id from EmployeeDetails a where a.employee_id=:empid" )
	public MinDetails getOrgListLowerEmpId1(@Param("empid") String empid);*/

@Query("select new com.accionlabs.data.MinDetails(a.employee_id ,a.employee_name, a.designation_name,a.project, a.reporting_to_by_id ) from EmployeeDetails a where a.employee_id=:empid" )
	public MinDetails getMinDetails(@Param("empid") String empid);
@Query("select new com.accionlabs.data.MinDetails(a.employee_id ,a.employee_name, a.designation_name,a.project, a.reporting_to_by_id ) from EmployeeDetails a where a.reporting_to_by_id=:empid and a.project=:project" )
public List<MinDetails> getMinDetailsList(@Param("empid") String empid, @Param("project")  String project);
@Query(" Select distinct a.employee_id from EmployeeDetails a where a.project=:project and  a.reporting_to_by_id=null ")
public Set<String> getProjectWiseNoManagersList(@Param("project") String project);
@Query(" Select distinct a.employee_id from EmployeeDetails a where a.reporting_to_by_id=:reporting_to_by_id and a.project=:project ")
public Set<String> getProjectWiseNoReportive( @Param("reporting_to_by_id") String empid, @Param("project")  String project);
}
