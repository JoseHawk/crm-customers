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
                .field("name", "name")
                .field("surname", "surname")
                .field("picturePath", "picturePath")
                .byDefault()
                .register();
    }
}