package com.evaluationproject.SpringBootCredit;

import com.evaluationproject.SpringBootCredit.modelclasses.ConnectingComponent;
import com.evaluationproject.SpringBootCredit.modelclasses.Credit;
import com.evaluationproject.SpringBootCredit.modelclasses.Customer;
import com.evaluationproject.SpringBootCredit.modelclasses.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/credit")
public class CreditController {


    private final CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    private Credit credit = new Credit();
    private Customer customer = new Customer();
    private Product product = new Product();


    @GetMapping(value = "/getCredits")
    public List<Credit> getCredits(){
        return creditService.getCredits();
    }

    @PostMapping(value = "/createCredit")
    public void createCredit(ConnectingComponent connectingComponent){
        product.setProductName(connectingComponent.getProductName());
        product.setValue(connectingComponent.getValue());

        customer.setFirstName(connectingComponent.getFirstName());
        customer.setSurname(connectingComponent.getSurname());
        customer.setPesel(connectingComponent.getPesel());

        credit.setProduct(product);
        credit.setCustomer(customer);
        credit.setCreditName(connectingComponent.getCreditName());

        creditService.createCredit(credit);
    }

}
