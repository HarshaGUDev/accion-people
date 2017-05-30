package com.accionlabs.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.accionlabs.data.EmployeeDetails;
import com.accionlabs.data.EmployeeDetails2;

public interface MinDetailsRepository extends CrudRepository<EmployeeDetails2, String> {
	@Query(" from EmployeeDetails where employee_id=:employee_id")
	public EmployeeDetails2 getFullDetails(@Param("employee_id") String employee_id);

}
