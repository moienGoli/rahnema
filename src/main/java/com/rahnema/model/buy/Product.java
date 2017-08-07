package com.rahnema.model.buy;

import com.rahnema.db.BaseEntity;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Holds information for product. It is intended to be used only for receipt
 * Created by moien on 8/6/2017.
 */

@Entity
public class Product extends BaseEntity {

    @Id
    private String id;
    private String description;
    private String merchantId;
    private double price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
