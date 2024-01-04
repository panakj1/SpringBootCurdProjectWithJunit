package com.curdOperation.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.curdOperation.Model.Company;
import com.curdOperation.RequestVO.CompanyVO;

@Mapper
public interface CompanyInterface {

	CompanyInterface INSTANCE=Mappers.getMapper(CompanyInterface.class);
	
	Company convertVOTOCompany(CompanyVO vo);
	
}
