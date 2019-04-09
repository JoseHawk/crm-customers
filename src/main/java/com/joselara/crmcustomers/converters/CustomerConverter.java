package com.joselara.crmcustomers.converters;

import com.joselara.crmcustomers.models.Customer;
import com.joselara.crmcustomers.models.dto.CustomerDTO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {

        factory.classMap(CustomerDTO.class, Customer.class)
                .field("customerId", "customerId")
                .field("name", "name")
                .field("surname", "surname")
                .field("picturePath", "picturePath")
                .field("createdBy", "createdBy")
                .field("insertTime", "insertTime")
                .field("modifiedBy", "modifiedBy")
                .field("modificationTime", "modificationTime")
                .byDefault()
                .register();
    }
}