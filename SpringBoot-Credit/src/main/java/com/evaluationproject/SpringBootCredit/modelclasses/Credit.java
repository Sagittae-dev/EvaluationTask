package com.evaluationproject.SpringBootCredit.modelclasses;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Credit {

    @Id
    @Column
    private int creditId;

    @NotNull
    @Column(name = "CreditName")
    private String creditName;

    @Transient
    private Customer customer;

    @Transient
    private Product product;

    public Credit(){}

    public Credit(int creditId, String creditName) {
        this.creditId = creditId;
        this.creditName = creditName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "creditId=" + creditId +
                ", creditName='" + creditName + '\'' +
                '}';
    }
}
