package com.joselara.crmcustomers.controllers;

import com.joselara.crmcustomers.models.Customer;
import com.joselara.crmcustomers.models.dto.CustomerDTO;
import com.joselara.crmcustomers.services.CustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/customer", consumes = "application/json")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerInformation,
                                                   @RequestHeader("User-Id") String userId) throws NotFoundException {
        return ResponseEntity.ok(customerService.createCustomer(customerInformation, userId));
    }

    @GetMapping(path = "/customer/{customerId}", consumes = "application/json")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") final UUID customerId) throws NotFoundException {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping(path = "/customers", consumes = "application/json")
    public ResponseEntity<List<Customer>> getAllCustomers() {

        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PutMapping(path = "/customer/{customerId}", consumes = "application/json")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") final UUID customerId,
                                                   @RequestBody CustomerDTO customerInformation,
                                                   @RequestHeader("User-Id") String userId) throws NotFoundException {
        return ResponseEntity.ok(customerService.updateCustomer(customerId, customerInformation, userId));
    }

    @DeleteMapping(path = "/customer/{customerId}", consumes = "application/json")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") final UUID customerId) throws NotFoundException {
        customerService.deleteCustomer(customerId);

        return ResponseEntity.noContent().build();
    }
}
