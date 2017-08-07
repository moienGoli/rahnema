package com.rahnema.model.User;

import com.rahnema.db.DAO;

/**
 * Created by moien on 8/6/2017.
 */
public interface UserRepository extends DAO<User, String> {
    void buyTransact(String id, double amount, String merchantId);
}
