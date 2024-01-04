package com.curdOperation.RequestVO;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyVO {

	
	@NotNull(message="Company Id should not be blank")
	private Long compId;
	@NotNull(message="Company Name should not be blank")
	private String compName;
	@NotNull(message="Company Address should not be blank")
	private String compAdd;
	public Long getCompId() {
		return compId;
	}
	public void setCompId(Long compId) {
		this.compId = compId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompAdd() {
		return compAdd;
	}
	public void setCompAdd(String compAdd) {
		this.compAdd = compAdd;
	}
	
}
