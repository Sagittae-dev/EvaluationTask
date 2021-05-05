# Evaluation Task for Inteca
The application has 3 spring boot components:

* SpringBoot Customer
* SpringBoot Credit
* SpringBoot Product

The database is postgreSQL

# How to run

* http://localhost:8080/api/credit/ - Credit functionality
  * http://localhost:8080/tapi/credit/getCredits - return credit list
  * http://localhost:8080/api/credit/createCredits - Create new Credit. With using Postman and method POST the loan data should be provided, for example, in JSON format as       follows: { "firstName": "Mateusz", "surname": "Nowak", "pesel": "09874903721", "productName": "Product one", "creditName": "Super Credit", "value": 32107 }
 
* http://localhost:8081/api/customer/ - Customer functionality
  * http://localhost:8081/api/customer/getCustomers - Return customers list
  * http://localhost:8081/api/customer/createCustomer - Create new Customer
  * http://localhost:8081/api/customer/getCustomer/{creditId}  - Get customer by credit id
  * http://localhost:8081/api/customer/{creditId} - Delete or update customer with Postman

* http://localhost:8082/api/product/ - Product functionality
  * http://localhost:8082/api/product/getProducts - Return products list
  * http://localhost:8082/api/product/createProduct - Create new Product
  * http://localhost:8082/api/product/getProduct/{creditId}  - Get product by credit id
 
