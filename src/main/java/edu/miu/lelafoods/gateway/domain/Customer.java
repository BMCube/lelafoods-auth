package edu.miu.lelafoods.gateway.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer extends User {

    @NotBlank
    private String customerNumber;

    public Customer() {
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}
