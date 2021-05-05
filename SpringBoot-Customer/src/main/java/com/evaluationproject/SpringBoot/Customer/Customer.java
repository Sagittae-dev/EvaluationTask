package com.evaluationproject.SpringBoot.Customer;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private int customerId;

    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @NotNull
    private String pesel;

    public Customer(){}

    public Customer(String firstName, String surname, String pesel) {
        this.firstName = firstName;
        this.surname = surname;
        this.pesel = pesel;
    }

    public Customer(int customerId,
                    String firstName,
                    String surname,
                    String pesel){
        this.customerId = customerId;
        this.firstName = firstName;
        this.surname = surname;
        this.pesel = pesel;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "creditId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
