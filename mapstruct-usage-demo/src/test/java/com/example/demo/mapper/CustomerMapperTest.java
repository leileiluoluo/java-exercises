package com.example.demo.mapper;

import com.example.demo.dto.CustomerDto;
import com.example.demo.vo.Address;
import com.example.demo.vo.Customer;
import org.junit.jupiter.api.Test;

public class CustomerMapperTest {

    @Test
    public void testToCustomerDto() {
        Customer customer = new Customer();
        customer.setName("Larry");
        customer.setYearOfBirth(2000);

        Address address = new Address();
        address.setProvince("Shandong");
        address.setCity("Qingdao");
        address.setStreet("Qingnian road");

        CustomerDto customerDto = CustomerMapper.INSTANCE.toCustomerDto(customer, address);
        System.out.println(customerDto);
    }

}
