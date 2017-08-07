package com.rahnema.model.User;

import com.rahnema.db.BaseRepository;
import com.rahnema.exception.AppException;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.stereotype.Repository;

/**
 * repository for user
 * Created by moien on 8/6/2017.
 */

@Repository
public class UserRepositoryImpl extends BaseRepository<User, String> implements UserRepository {

    public UserRepositoryImpl() {
        super(User.class);
    }

    public void buyTransact(String id, double amount, String merchantId) {

        Query<User> query = createQuery().field(User.ID_FIELD).equal(id);
        query.field(User.BALANCE_FIELD).greaterThan(amount);
        UpdateOperations<User> updateOperations = createUpdateOperations();
        updateOperations.inc(User.BALANCE_FIELD, (amount * -1));
        UpdateResults updateResults = update(query, updateOperations);


        if (updateResults.getUpdatedCount() == 0) {
            throw new AppException("The credit is not enough");
        }
        incBalance(merchantId, amount);
    }

    public void incBalance(String id, double amount) {

        Query<User> query = createQuery().field(User.ID_FIELD).equal(id);
        UpdateOperations<User> updateOperations = createUpdateOperations();
        updateOperations.inc(User.BALANCE_FIELD, (amount));
        UpdateResults updateResults = update(query, updateOperations);
    }
}
