package com.example.demo.mapper;

import com.example.demo.dto.CustomerDto;
import com.example.demo.vo.Address;
import com.example.demo.vo.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "customer.name", target = "name")
    @Mapping(source = "customer.yearOfBirth", target = "yearOfBirth")
    @Mapping(source = "address.province", target = "province")
    @Mapping(source = "address.city", target = "city")
    @Mapping(source = "address.street", target = "street")
    CustomerDto toCustomerDto(Customer customer, Address address);

}
