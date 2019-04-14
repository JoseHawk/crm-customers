[![Build Status](https://travis-ci.org/JoseHawk/crm-customers.svg?branch=master)](https://travis-ci.org/JoseHawk/crm-customers)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.joselara%3Acrm-customers&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.joselara%3Acrm-customers)
[![License](https://img.shields.io/badge/License-GNU%20General%20Public%20License%203.0-brightgreen.svg)](http://www.gnu.org/licenses/gpl-3.0.txt)

# CRM-Customers
The CRM-Customers is a microservice part of the CRM Service. Its domain is to manage and persist the customers.

## Getting started

In order to run the application, you will need to add the JASYPT_PASSWORD environment variable. Please, ask the creator in order to provide it.
After that, you will only need to run the "docker-compose" that is located under resources, in order to run a MySQL instance and create the database.
If you want to run all the "CRM Service" applications at the same time, you will have to run only one "docker-compose" and create manually the other databases. For example, if you run "docker-compose up" in "crm-users", you will need to create manually the "crm-documents" and "crm-customers" databases.

### REST API documentation

This documentation is available, when running the application, at the URL: http://localhost:8091/swagger-ui.html
## Built with

 * Spring framework
 * Hibernate
 * OAUTH2
 * Zuul
 * Hystrix
 * Eureka
 * Flyway
 * MySQL
 * Orika
 * Swagger
 * Wiremock
 * Jasypt
 * BouncyCastle
 * Maven
 
### Related tools

 * Sonar
 * Jacoco
 * Pivotal Cloud Foundry
 
## Authors

 * **Jose Lara** - *Hawcode co founder and developer* - [Email](LaraGomezJC@gmail.com) - [LinkedIn](https://es.linkedin.com/in/josecarloslaragomez)
