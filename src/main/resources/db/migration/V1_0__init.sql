CREATE TABLE customer
(
    customer_id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL ,
    surname VARCHAR(100) NOT NULL,
    picture_path VARCHAR(255),
    created_by VARCHAR(100),
    insert_time VARCHAR(50),
    modified_by VARCHAR(100),
    modification_time VARCHAR(50)
);