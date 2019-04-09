package com.joselara.crmcustomers.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Customer {

    @Id
    @NotNull
    private UUID customerId;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    private String picturePath;

    private String createdBy;

    private LocalDateTime insertTime;

    private String modifiedBy;

    private LocalDateTime modificationTime;
}
