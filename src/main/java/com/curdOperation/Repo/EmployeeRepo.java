package com.curdOperation.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curdOperation.Model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
	Employee findByEmpIdAndCompCompId(Long id,Long compId);

}
