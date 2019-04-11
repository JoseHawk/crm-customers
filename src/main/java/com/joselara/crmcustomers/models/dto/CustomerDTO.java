package com.joselara.crmcustomers.models.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.UUID;

@Data
@Builder
public class CustomerDTO {

    private String name;
    private String surname;
    private String picturePath;

    @Tolerate
    public CustomerDTO() { }
}
