package com.joselara.crmcustomers.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
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
