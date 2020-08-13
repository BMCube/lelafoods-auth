package edu.miu.lelafoods.gateway.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
public class RestaurantManager extends User {

    public RestaurantManager() {
    }

    public RestaurantManager(@NotEmpty String username, String password, @NotBlank String firstName, String middleName, @NotBlank String lastName) {
        super(username, password, firstName, middleName, lastName, new ArrayList<>(Arrays.asList("ROLE_RESTAURANT_MANAGER")));
    }

}
