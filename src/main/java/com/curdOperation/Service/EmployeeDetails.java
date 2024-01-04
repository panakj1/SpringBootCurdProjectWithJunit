package com.curdOperation.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.curdOperation.Constant.Constant;
import com.curdOperation.Exception.InvalidException;
import com.curdOperation.Mapper.EmployeMapper;
import com.curdOperation.Model.Company;
import com.curdOperation.Model.Employee;
import com.curdOperation.Repo.CompanyRepo;
import com.curdOperation.Repo.EmployeeRepo;
import com.curdOperation.RequestVO.EmployeeVO;


@Service
@Transactional
public class EmployeeDetails {
	@Autowired
	EmployeeRepo  employeeRepo;
	@Autowired
	CompanyRepo  companyRepo;
	
	Logger logger=LoggerFactory.getLogger(EmployeeDetails.class);
	
	public void  rgistrationEmployeeDetails(EmployeeVO empVO) {
		try {
		Employee emp=EmployeMapper.INSTANCE.convertVOToEmployee(empVO);
		employeeRepo.save(emp);
		}catch(InvalidException e) {
			throw new InvalidException(Constant.inputValidation);
		}
				
	}
	
	public List<EmployeeVO> getAllEmpDetails(){
		List<Employee> emp=employeeRepo.findAll();
		List<EmployeeVO> empVo=EmployeMapper.INSTANCE.convertDoTOVO(emp);
		return empVo;
	}
	
	public String updatEmployee(EmployeeVO vo) {
		boolean status=false;
		Employee value=employeeRepo.findByEmpIdAndCompCompId(vo.getEmpId(),vo.getComp().getCompId());
		if(!ObjectUtils.isEmpty(value)) {
			Employee emp=EmployeMapper.INSTANCE.convertVOToEmployee(vo);
			employeeRepo.save(emp);
			status=true;
		}else {
			return "No found any record on this id";
		}
		if(status) {
			return "Record updeted succfully";
		}else {
			return "Record is not updated";
		}
	}
	
	
	public String deleteRecord(Long id) {
		boolean status=false;
		Optional<Employee> value=employeeRepo.findById(id);
		if(value.isPresent()) {
			employeeRepo.deleteById(id);
			status=true;
		}else {
			return "No found any record on this id";
		}
		if(status) {
			return "Record Delete succfully";
		}else {
			return "Record is not Deleted";
		}
		
	}

}
