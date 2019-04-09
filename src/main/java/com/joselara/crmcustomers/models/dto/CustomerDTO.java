package com.joselara.crmcustomers.models.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CustomerDTO {

    private UUID customerId;
    private String name;
    private String surname;
    private String picturePath;
    private String createdBy;
    private LocalDateTime insertTime;
    private String modifiedBy;
    private LocalDateTime modificationTime;
}
