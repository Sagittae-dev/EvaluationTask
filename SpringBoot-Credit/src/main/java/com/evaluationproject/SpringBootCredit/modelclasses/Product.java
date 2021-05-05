package com.evaluationproject.SpringBootCredit.modelclasses;

public class Product {

    private int creditId, value;

    private String productName;

    public Product(){}

    public Product(int creditId, int value, String productName) {
        this.creditId = creditId;
        this.value = value;
        this.productName = productName;
    }

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "creditId=" + creditId +
                ", value=" + value +
                ", productName='" + productName + '\'' +
                '}';
    }
}
