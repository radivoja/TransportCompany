package com.qinshift.apiFirst.mappers;

import com.qinshift.apiFirst.dto.Company;
import com.qinshift.apiFirst.entity.CompanyEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring", uses = DriverMapper.class)
public interface CompanyMapper {
    Company map(CompanyEntity company);
    CompanyEntity map(Company company);

    List<Company> mapToEntity(List<CompanyEntity> companies);
    List<CompanyEntity> mapToDto(List<Company> companies);

}
