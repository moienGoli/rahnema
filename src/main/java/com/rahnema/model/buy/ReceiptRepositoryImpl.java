package com.rahnema.model.buy;

import com.rahnema.db.BaseRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

/**
 * repository for receipts
 * Created by moien on 8/6/2017.
 */

@Repository
public class ReceiptRepositoryImpl extends BaseRepository<Receipt, ObjectId> implements ReceiptRepository {

    public ReceiptRepositoryImpl() {
        super(Receipt.class);
    }
}
