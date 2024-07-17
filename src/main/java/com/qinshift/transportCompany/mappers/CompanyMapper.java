package com.qinshift.transportCompany.mappers;

import com.qinshift.transportCompany.dto.Company;
import com.qinshift.transportCompany.entity.CompanyEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring", uses = DriverMapper.class)
public interface CompanyMapper {
    Company map(CompanyEntity company);
    CompanyEntity map(Company company);

    List<Company> mapToDto(List<CompanyEntity> companies);
    List<CompanyEntity> mapToEntity(List<Company> companies);

}
