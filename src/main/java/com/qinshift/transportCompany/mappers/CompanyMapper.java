package com.qinshift.transportCompany.mappers;

import com.qinshift.transportCompany.dto.CompanyDto;
import com.qinshift.transportCompany.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = DriverMapper.class)
public interface CompanyMapper {
    @Mapping(target = "drivers", source = "drivers", ignore = true) // circular dependencies
    CompanyDto map(Company company);

    @Mapping(target = "drivers", source = "drivers", ignore = true) // circular dependencies
    Company map(CompanyDto companyDto);

    List<CompanyDto> mapToDto(List<Company> companies);

    List<Company> mapToEntity(List<CompanyDto> companiesDto);

}
