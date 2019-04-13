package com.joselara.crmcustomers.repositories;

import com.joselara.crmcustomers.models.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@ActiveProfiles("test")public class CustomerRepositoryIntegrationTest {

    @Autowired
    private CustomerRepository cut;

    @Test
    public void testSaveAndDeleteCustomer() {
        Customer customer = new Customer();
        customer.setName("testName");
        customer.setSurname("testSurname");

        cut.save(customer);

        Customer retrievedCustomer = cut.findAll().get(0);
        assertEquals(customer, retrievedCustomer);

        cut.delete(customer);

        assertEquals(0, cut.findAll().size());
    }
}
