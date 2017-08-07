package com.rahnema.model.buy;

import com.rahnema.db.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by moien on 8/6/2017.
 */

@Repository
public class ProductRepositoryImpl extends BaseRepository<Product, String> implements ProductRepository {

    public ProductRepositoryImpl() {
        super(Product.class);
    }
}
