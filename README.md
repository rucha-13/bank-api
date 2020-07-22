# bank-api

Assignment:
Create a Spring Boot service implementation which exposes the following REST endpoints 

- Retrieve a customer for a given customer id 
- Retrieve an account for a given account id
- Retrieve a transaction for a given transaction id
- Retrieve a list of transactions for a given account id in reverse time order.

Access to all endpoints should only be permitted if the request has a header with the name "lean-token" and the value is contained within the whitelist file provided.

Application URL:
http://localhost:8090/

Swagger REST API documentation presented here (after application start):
http://localhost:8090/swagger-ui.html

Database:
H2 databse is used in this application
Required data is already present in the database.
