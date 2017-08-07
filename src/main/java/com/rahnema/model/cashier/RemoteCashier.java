package com.rahnema.model.cashier;

import com.rahnema.exception.AppException;
import com.rahnema.model.buy.Receipt;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by moien on 8/6/2017.
 */

@Profile("remote")
@Service
public class RemoteCashier implements CashierService {

    public Receipt buy(String phone, String product) {
        //will call a WS for remote cashier
        throw new AppException("Remote cashier is Not Implemented. Add 'cashier' as your active profile");
    }

}
