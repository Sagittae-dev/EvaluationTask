package com.evaluationproject.SpringBootCredit.modelclasses;

/*Class for connect Credit, Product and Customer informations*/

public class ConnectingComponent {
    private String firstName, surname, pesel, productName, creditName;
    private int value;

    public ConnectingComponent(){}

    public ConnectingComponent(String firstName, String surname, String pesel, String productName, String creditName, int value) {
        this.firstName = firstName;
        this.surname = surname;
        this.pesel = pesel;
        this.productName = productName;
        this.creditName = creditName;
        this.value = value;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
