package com.evaluationproject.SpringBootCredit;

import com.evaluationproject.SpringBootCredit.modelclasses.Credit;
import com.evaluationproject.SpringBootCredit.modelclasses.Customer;
import com.evaluationproject.SpringBootCredit.modelclasses.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CreditService {

    private final CreditRepository creditRepository;

    @Autowired
    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }
    @Autowired
    private RestTemplate restTemplate;

    private List<Credit> creditList;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public List<Credit> getCredits() {
        creditList = creditRepository.findAll();
        for (Credit credit : creditList){
            credit.setCustomer(restTemplate.getForObject("http://localhost:8081/api/customer/getCustomer"+credit.getCreditId(), Customer.class));
            credit.setProduct(restTemplate.getForObject("http://localhost:8082/api/product/getProduct"+credit.getCreditId(), Product.class));
        }
        return creditList;
    }

    public void createCredit(Credit credit){

        int generatedCreditID = createCreditNumber();

        credit.setCreditId(generatedCreditID);
        credit.getCustomer().setCreditId(generatedCreditID);
        credit.getProduct().setCreditId(generatedCreditID);

        creditRepository.save(credit);

        restTemplate.postForObject("http://localhost:8081/api/customer/createCustomer", credit.getCustomer(), Customer.class);
        restTemplate.postForObject("http://localhost:8082/api/product/createProduct", credit.getProduct(), Product.class);

    }

    private int createCreditNumber(){
        creditList = creditRepository.findAll();
        if (creditList.isEmpty())
            return 1;
        else
            return Collections.max(creditList, Comparator.comparing(Credit::getCreditId)).getCreditId() + 1;
    }

}
