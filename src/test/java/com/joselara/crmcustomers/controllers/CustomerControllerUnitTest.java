package com.joselara.crmcustomers.controllers;

import com.joselara.crmcustomers.models.Customer;
import com.joselara.crmcustomers.models.dto.CustomerDTO;
import com.joselara.crmcustomers.services.CustomerService;
import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerUnitTest {

    @InjectMocks
    private CustomerController cut;

    @Mock
    private CustomerService customerService;

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer();
        customer.setName("testName");
        customer.setSurname("testSurname");
    }

    @Test
    public void createCustomerTest() {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("testName")
                .surname("testSurname")
                .build();
        when(customerService.createCustomer(customerDTO)).thenReturn(customer);

        Customer actualCustomer = cut.createCustomer(customerDTO).getBody();

        assertEquals(customer, actualCustomer);
    }

    @Test
    public void getCustomerByIdTest() throws NotFoundException {
        UUID customerId = UUID.randomUUID();
        when(customerService.getCustomerById(customerId)).thenReturn(customer);

        Customer actualCustomer = cut.getCustomerById(customerId).getBody();

        assertEquals(customer, actualCustomer);
    }

    @Test
    public void getAllCustomersTest() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        when(customerService.getAllCustomers()).thenReturn(customerList);

        List<Customer> actualCustomerList = cut.getAllCustomers().getBody();

        assertEquals(customer, actualCustomerList.get(0));
        assertEquals(1, actualCustomerList.size());
    }

    @Test
    public void updateCustomerTest() throws NotFoundException {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("testName")
                .surname("testSurname")
                .build();
        UUID customerId = UUID.randomUUID();
        when(customerService.updateCustomer(customerId, customerDTO)).thenReturn(customer);

        Customer actualCustomer = cut.updateCustomer(customerId, customerDTO).getBody();

        assertEquals(customer, actualCustomer);
    }

    @Test
    public void deleteCustomerTest() throws NotFoundException {
        UUID customerId = UUID.randomUUID();
        doNothing().when(customerService).deleteCustomer(customerId);

        ResponseEntity<Void> responseEntity = cut.deleteCustomer(customerId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}
