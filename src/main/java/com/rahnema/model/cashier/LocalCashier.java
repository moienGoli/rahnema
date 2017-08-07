package com.rahnema.model.cashier;

import com.rahnema.exception.AppException;
import com.rahnema.model.User.User;
import com.rahnema.model.User.UserRepository;
import com.rahnema.model.buy.Product;
import com.rahnema.model.buy.ProductRepository;
import com.rahnema.model.buy.Receipt;
import com.rahnema.model.buy.ReceiptRepository;
import org.mongodb.morphia.Key;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;

/**
 * will receive a transaction and call the treasury
 * Created by moien on 8/6/2017.
 */


@Profile("cashier")
@Service
public class LocalCashier implements CashierService {

    private final UserRepository userRepository;
    private final ReceiptRepository receiptRepository;
    private final ProductRepository productRepository;

    @Inject
    public LocalCashier(ReceiptRepository receiptRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.receiptRepository = receiptRepository;
        this.productRepository = productRepository;
    }

    public Receipt buy(String phone, String product) {
        return buy(phone, productRepository.get(product));
    }

    private Receipt buy(String phone, Product product) {

//        validateUser(phone, product);

        try {
            userRepository.buyTransact(phone, product.getPrice(), product.getMerchantId());
            return createReceipt(phone, product);
        } catch (Exception e) {
            throw new AppException("Not enough credit. Auto retry mechanism is not implemented");
        }

    }

    private void validateUser(String phone, Product product) {
        User user = userRepository.get(phone);
        if (user == null) {
            throw new AppException("No Such customer");

        }
        User merchant = userRepository.get(product.getMerchantId());
        if (merchant == null) {
            throw new AppException("No Such merchant");

        }
    }

    private Receipt createReceipt(String customerPhone, Product product) {

        Receipt receipt = new Receipt();
        receipt.setAmount(product.getPrice());
        receipt.setMerchantId(product.getMerchantId());
        receipt.setCustomerId(customerPhone);
        receipt.setDate(new Date());
        Key<Receipt> save = receiptRepository.save(receipt);
        return receipt;
    }


}
