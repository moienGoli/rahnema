package com.rahnema.model.User;

import com.rahnema.db.BaseEntity;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * A user of a treasury could be a merchant or customer
 * Created by moien on 8/6/2017.
 */

@Entity
public class User extends BaseEntity {

    public static String ID_FIELD = "id";
    public static String BALANCE_FIELD = "balance";


    @Id
    private String id;
    private double balance;
    private UserType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public UserType getType() {
        return type;
    }

    protected void setType(UserType type) {
        this.type = type;
    }


}
