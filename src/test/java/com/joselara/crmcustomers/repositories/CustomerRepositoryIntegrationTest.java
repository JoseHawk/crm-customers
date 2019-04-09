package com.joselara.crmcustomers.repositories;

import com.joselara.crmcustomers.models.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryIntegrationTest {

    @Autowired
    private CustomerRepository cut;

    @Test
    public void testSaveAndDeleteCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(UUID.randomUUID());
        customer.setName("testName");
        customer.setSurname("testSurname");

        cut.save(customer);

        Customer retrievedCustomer = cut.findAll().get(0);
        assertEquals(customer, retrievedCustomer);

        cut.delete(customer);

        assertEquals(0, cut.findAll().size());
    }
}
