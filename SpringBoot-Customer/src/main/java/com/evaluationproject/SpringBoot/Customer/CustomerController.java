package com.evaluationproject.SpringBoot.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="api/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(value = "/getCustomers")
    public List<Customer> getCustomers(){
            return customerService.getCustomers();
    }

    @GetMapping(value = "/getCustomer/{creditId}")
    public Optional<Customer> getCustomer(@PathVariable("creditId") int creditId){
        return customerService.getCustomer(creditId);
    }

    @PostMapping(value = "/createCustomer")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerService.deleteCustomer(id);
    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") int customerId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String pesel){
        customerService.updateCustomer(customerId, firstName, surname, pesel);
    }
}
