package com.curdOperation.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.curdOperation.Constant.Constant;
import com.curdOperation.Exception.InvalidException;
import com.curdOperation.RequestVO.CompanyVO;
import com.curdOperation.RequestVO.EmployeeVO;
import com.curdOperation.Service.EmployeeDetails;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationTestController {

	@InjectMocks
	private EmployeeRegistrationController empControllerController;
	@Mock
	EmployeeDetails employeeDetails;

	@Test
	public void getTestAllDetails() {
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		EmployeeVO vo = new EmployeeVO();
		vo.setEmpId(1L);
		vo.setEmpName("Ashok");
		vo.setDepartment("Software");
		vo.setAge(30);
		list.add(vo);
		Mockito.when(employeeDetails.getAllEmpDetails()).thenReturn(list);
		ResponseEntity<List<EmployeeVO>> actualRecord = empControllerController.getAllRecord();
		assertThat(actualRecord).isNotNull();
	}

	@Test
	public void updateDetails() {
		EmployeeVO vo = new EmployeeVO();
		String updateMsg = "Record updated succesfully";
		vo.setEmpId(1L);
		vo.setEmpName("Ashok");
		CompanyVO comp = new CompanyVO();
		comp.setCompId(1L);
		vo.setComp(comp);
		Mockito.when(employeeDetails.updatEmployee(vo)).thenReturn(null);
		ResponseEntity<String> result = empControllerController.updateEmployeeDetails(vo);
		assertEquals(updateMsg, result.getBody());
	}

	@Test
	public void elseUpdateDetails() {
		EmployeeVO vo = new EmployeeVO();
		vo.setEmpName("Ashok");
		// Mockito.doThrow(RuntimeException.class).when(employeeDetails.updatEmployee(vo));
		InvalidException exception = Assertions.assertThrows(InvalidException.class, () -> {
			empControllerController.updateEmployeeDetails(vo);
		});
		String expectedMessage = Constant.inputValidation;
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void saveDetails() {
		EmployeeVO vo = new EmployeeVO();
		String updateMsg = "Save succesfully";
		vo.setEmpId(1L);
		vo.setEmpName("Ashok");
		CompanyVO comp = new CompanyVO();
		comp.setCompId(1L);
		vo.setComp(comp);
		Mockito.doNothing().when(employeeDetails).rgistrationEmployeeDetails(vo);
		ResponseEntity<String> result = empControllerController.registrationEmployeeDetails(vo);
		;
		assertEquals(updateMsg, result.getBody());
	}

}
