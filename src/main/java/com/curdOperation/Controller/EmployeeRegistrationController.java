package com.curdOperation.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curdOperation.Constant.Constant;
import com.curdOperation.Exception.InvalidException;
import com.curdOperation.RequestVO.EmployeeVO;
import com.curdOperation.Service.EmployeeDetails;

@RestController
@RequestMapping("/Information")
public class EmployeeRegistrationController {

	Logger logger = LoggerFactory.getLogger(EmployeeRegistrationController.class);

	@Autowired
	EmployeeDetails empService;

	@PostMapping(value = "/save")
	public ResponseEntity<String> registrationEmployeeDetails(@Valid @RequestBody EmployeeVO empVO) {
		try {
			empService.rgistrationEmployeeDetails(empVO);
		return new ResponseEntity<String>(Constant.saveMsg, HttpStatus.CREATED);
		}catch(InvalidException e) {
			throw new InvalidException(Constant.inputValidation);
		}
	}
	
	
	@GetMapping(value = "/getAllRecord")
	public ResponseEntity<List<EmployeeVO>> getAllRecord() {
		List<EmployeeVO> list=empService.getAllEmpDetails();
		return new ResponseEntity<List<EmployeeVO>>(list,HttpStatus.OK);
	}
	@DeleteMapping(value="/deleteRecord/{id}")
	public ResponseEntity<String> deleteRecord(@PathVariable("id") Long id){
		      String result=empService.deleteRecord(id);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<String> updateEmployeeDetails(@RequestBody EmployeeVO empVO) {
		if(!ObjectUtils.isEmpty(empVO.getEmpId()) && !ObjectUtils.isEmpty(empVO.getComp().getCompId())) {
		empService.updatEmployee(empVO);
		return new ResponseEntity<String>(Constant.updateMsg, HttpStatus.CREATED);
		}else {
			throw new InvalidException(Constant.inputValidation);	
		}
	}
	
}
