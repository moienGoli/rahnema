package com.rahnema.model.cashier;

import com.rahnema.model.buy.Receipt;

/**
 * Created by moien on 8/6/2017.
 */


public interface CashierService {

    Receipt buy(String phone, String product);
}
