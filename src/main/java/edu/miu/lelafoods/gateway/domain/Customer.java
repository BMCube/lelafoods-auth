package edu.miu.lelafoods.gateway.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Customer extends User {

    @NotBlank
    private String customerNumber;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;

    public Customer() {
    }

    public Customer(@NotEmpty String username, String password, @NotBlank String firstName, String middleName, @NotBlank String lastName, List<String> roles, @NotBlank String customerNumber, Address address) {
        super(username, password, firstName, middleName, lastName, roles);
        this.customerNumber = customerNumber;
        this.address = address;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
