package com.qinshift.transportCompany.mappers;

import com.qinshift.transportCompany.dto.Company;
import com.qinshift.transportCompany.entity.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", uses = DriverMapper.class)
public interface CompanyMapper {
    @Mapping(target = "drivers", source = "drivers", ignore = true) // circular dependencies

    Company map(CompanyEntity company);
    @Mapping(target = "drivers", source = "drivers", ignore = true) // circular dependencies

    CompanyEntity map(Company company);

    List<Company> mapToDto(List<CompanyEntity> companies);
    List<CompanyEntity> mapToEntity(List<Company> companies);

}
