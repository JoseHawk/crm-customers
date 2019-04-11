package com.joselara.crmcustomers.services;

import com.joselara.crmcustomers.converters.CustomerConverter;
import com.joselara.crmcustomers.models.Customer;
import com.joselara.crmcustomers.models.dto.CustomerDTO;
import com.joselara.crmcustomers.repositories.CustomerRepository;
import javassist.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    private static final Logger LOG = LogManager.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    public Customer createCustomer(CustomerDTO customerInformation, String userId) throws NotFoundException {
        LOG.trace("Checking if user ID is valid");
        if (userId == null) {
            throw new NotFoundException("User ID not valid");
        }

        LOG.trace("Mapping customer information");
        Customer customer = customerConverter.map(customerInformation, Customer.class);

        LOG.trace("Inserting relevant customer information");
        customer.setInsertTime(LocalDateTime.now());
        customer.setCreatedBy(userId);

        LOG.trace("Saving in database");
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

    public Customer updateCustomer(UUID customerId, CustomerDTO newCustomerInformation, String userId) throws NotFoundException {
        LOG.trace("Checking if user ID is valid");
        if (userId == null) {
            throw new NotFoundException("User ID not valid");
        }

        LOG.trace("Retrieving the customer by the ID");
        Customer customer = getCustomerById(customerId);

        LOG.trace("Updating customer information");
        updateCustomerInformation(customer, newCustomerInformation, userId);

        LOG.trace("Saving changes in customer");
        customerRepository.save(customer);

        return customer;
    }

    public void deleteCustomer(UUID customerId) throws NotFoundException {
        Customer customer = getCustomerById(customerId);

        customerRepository.delete(customer);
    }

    private void updateCustomerInformation(Customer oldCustomer, CustomerDTO newCustomer, String userId) {
        oldCustomer.setName(newCustomer.getName());
        oldCustomer.setSurname(newCustomer.getSurname());
        oldCustomer.setPicturePath(newCustomer.getPicturePath());
        oldCustomer.setModificationTime(LocalDateTime.now());
        oldCustomer.setModifiedBy(userId);
    }
}