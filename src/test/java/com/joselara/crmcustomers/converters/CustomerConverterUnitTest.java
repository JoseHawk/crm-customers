package com.joselara.crmcustomers.converters;

import com.joselara.crmcustomers.models.Customer;
import com.joselara.crmcustomers.models.dto.CustomerDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CustomerConverterUnitTest {

    @InjectMocks
    private CustomerConverter cut;

    @Test
    public void mapTest() {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("testName")
                .surname("testSurname")
                .picturePath("testPath")
                .build();

        Customer customer = cut.map(customerDTO, Customer.class);

        assertEquals(customer.getName(), customerDTO.getName());
    }
}
