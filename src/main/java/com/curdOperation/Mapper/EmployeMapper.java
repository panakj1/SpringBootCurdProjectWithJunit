package com.curdOperation.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.curdOperation.Model.Employee;
import com.curdOperation.RequestVO.EmployeeVO;

@Mapper
public interface EmployeMapper {
	
	EmployeMapper INSTANCE=Mappers.getMapper(EmployeMapper.class);
	
	Employee convertVOToEmployee(EmployeeVO vo);
	List<EmployeeVO> convertDoTOVO(List<Employee> emp);
}
