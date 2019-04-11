package com.joselara.crmcustomers.services;

import com.joselara.crmcustomers.converters.CustomerConverter;
import com.joselara.crmcustomers.models.Customer;
import com.joselara.crmcustomers.models.dto.CustomerDTO;
import com.joselara.crmcustomers.repositories.CustomerRepository;
import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceUnitTest {

    @InjectMocks
    private CustomerService cut;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerConverter customerConverter;

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer();
        customer.setName("testName");
        customer.setSurname("testSurname");
    }

    @Test
    public void createCustomerSuccess() throws NotFoundException {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("testName")
                .surname("testSurname")
                .build();
        String userId = "test@domain.com";
        when(customerConverter.map(customerDTO, Customer.class)).thenReturn(customer);

        Customer expectedCustomer = cut.createCustomer(customerDTO, userId);

        assertEquals(expectedCustomer.getName(), customer.getName());
        assertEquals(expectedCustomer.getCreatedBy(), userId);
    }

    @Test(expected = NotFoundException.class)
    public void createCustomerFails() throws NotFoundException {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("testName")
                .surname("testSurname")
                .build();

         cut.createCustomer(customerDTO, null);
    }

    @Test
    public void getCustomerByIdSuccess() throws NotFoundException {
        when(customerRepository.findById(any())).thenReturn(Optional.of(customer));

        Customer expectedCustomer = cut.getCustomerById(UUID.randomUUID());

        assertEquals(expectedCustomer.getName(), customer.getName());
    }

    @Test(expected = NotFoundException.class)
    public void getCustomerByIdFail() throws NotFoundException {
        when(customerRepository.findById(any())).thenReturn(Optional.empty());

        cut.getCustomerById(UUID.randomUUID());
    }

    @Test
    public void getAllCustomersSuccess() {
        when(customerRepository.findAll()).thenReturn(List.of(customer));

        List<Customer> customerList = cut.getAllCustomers();

        assertEquals(customer.getName(), customerList.get(0).getName());
        assertEquals(1, customerList.size());
    }

    @Test
    public void updateCustomerSuccess() throws NotFoundException {
        when(customerRepository.findById(any())).thenReturn(Optional.of(customer));
        CustomerDTO customerInformation = CustomerDTO.builder()
                .name("newName")
                .surname("newSurname")
                .build();
        String userId = "test@domain.com";

        Customer actualCustomer = cut.updateCustomer(UUID.randomUUID(), customerInformation, userId);

        assertEquals(customerInformation.getName(), actualCustomer.getName());
        assertEquals(userId, actualCustomer.getModifiedBy());
    }

    @Test
    public void deleteCustomerSuccess() throws NotFoundException {
        when(customerRepository.findById(any())).thenReturn(Optional.of(customer));

        cut.deleteCustomer(UUID.randomUUID());

        verify(customerRepository).delete(any());
    }
}
