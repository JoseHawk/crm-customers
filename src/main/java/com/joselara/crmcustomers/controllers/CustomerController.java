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

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerInformation) {
        return ResponseEntity.ok(customerService.createCustomer(customerInformation));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@RequestParam("customerId") final UUID customerId) throws NotFoundException {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@RequestParam("customerId") final UUID customerId,
                                                   @RequestBody CustomerDTO customerInformation) throws NotFoundException {
        return ResponseEntity.ok(customerService.updateCustomer(customerId, customerInformation));
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@RequestParam("customerId") final UUID customerId) throws NotFoundException {
        customerService.deleteCustomer(customerId);

        return ResponseEntity.noContent().build();
    }
}
