package com.evaluationproject.SpringBoot.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
      return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(int creditId) {
        return customerRepository.findById(creditId);
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerByPesel = customerRepository.findCustomerByPesel(customer.getPesel());
        if(customerByPesel.isPresent()){
            throw new IllegalStateException("Pesel taken");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer customerId) {
        boolean customerExist = customerRepository.existsById(customerId);
        if (!customerExist){
            throw new IllegalStateException("customer with id: " +customerId+" doesn't exist");
        }
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(int customerId, String firstName, String surname, String pesel) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new IllegalStateException(
                        "customer with id: " +customerId+" doesn't exist"));

        if (firstName !=null && firstName.length() > 0 && !Objects.equals(customer.getFirstName(), firstName)){
            customer.setFirstName(firstName);
        }
        if (surname !=null && surname.length() > 0 && !Objects.equals(customer.getSurname(), surname)){
            customer.setSurname(surname);
        }
        if (pesel !=null && pesel.length() > 0 && !Objects.equals(customer.getPesel(), pesel)){
            Optional<Customer> customerOptional = customerRepository.findCustomerByPesel(pesel);
            if(customerOptional.isPresent()){
                throw new IllegalStateException("pesel taken");
            }
            customer.setPesel(pesel);
        }
    }
}
