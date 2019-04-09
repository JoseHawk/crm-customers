package com.joselara.crmcustomers.services;

import com.joselara.crmcustomers.converters.CustomerConverter;
import com.joselara.crmcustomers.models.Customer;
import com.joselara.crmcustomers.models.dto.CustomerDTO;
import com.joselara.crmcustomers.repositories.CustomerRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    public Customer createCustomer(CustomerDTO customerInformation) {
        Customer customer = customerConverter.map(customerInformation, Customer.class);
        customer.setInsertTime(LocalDateTime.now());

        customerRepository.save(customer);

        return customer;
    }

    public Customer getCustomerById(UUID customerId) throws NotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new NotFoundException("Customer not found");
        }
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(UUID customerId, CustomerDTO newCustomerInformation) throws NotFoundException {
        Customer customer = getCustomerById(customerId);

        updateCustomerInformation(customer, newCustomerInformation);

        return customer;
    }

    public void deleteCustomer(UUID customerId) throws NotFoundException {
        Customer customer = getCustomerById(customerId);

        customerRepository.delete(customer);
    }

    private void updateCustomerInformation(Customer oldCustomer, CustomerDTO newCustomer) {
        oldCustomer.setName(newCustomer.getName());
        oldCustomer.setSurname(newCustomer.getSurname());
        oldCustomer.setModificationTime(LocalDateTime.now());
    }
}