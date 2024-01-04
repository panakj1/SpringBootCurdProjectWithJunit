package com.curdOperation.Exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	     
	
	@ExceptionHandler(InvalidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<RessponseException> getRuntimeException(InvalidException ex,HttpServletRequest request){
		RessponseException re=new RessponseException();
		re.setError(ex.getMessage());
		re.setText(request.getMethod());
		return new ResponseEntity<RessponseException>(re,HttpStatus.BAD_REQUEST);
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String,String>  getValidationExceptionHandle(MethodArgumentNotValidException ex){
	  Map<String,String> errorMap=new HashMap<String,String>();
	  ex.getBindingResult().getFieldErrors().forEach(error->{
		  errorMap.put(error.getField(), error.getDefaultMessage());
	  });
	  return errorMap;
  }
}
