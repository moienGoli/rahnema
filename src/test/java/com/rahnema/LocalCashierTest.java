package com.rahnema;

import com.rahnema.model.User.User;
import com.rahnema.model.User.UserRepository;
import com.rahnema.model.buy.Product;
import com.rahnema.model.buy.ProductRepository;
import com.rahnema.model.buy.Receipt;
import com.rahnema.model.buy.ReceiptRepository;
import com.rahnema.model.cashier.CashierService;
import com.rahnema.model.cashier.LocalCashier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;


/**
 * Unit test for cashier
 */
@RunWith(MockitoJUnitRunner.class)
public class LocalCashierTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private ReceiptRepository receiptRepository;
    @Mock
    private ProductRepository productRepository;


    @Test
    public void testBuy() {

        String phone = "09141026539";
        String productId = "productID";
        double amount = (9);
        double balance = (10);
        Mockito.when(userRepository.get(phone)).thenReturn(getCustomerWithCredit(phone, balance));
        Mockito.when(productRepository.get(productId)).thenReturn(createProductWithPrice(amount));
        User user = userRepository.get("09141026539");
        Mockito.doNothing().when(userRepository).buyTransact(phone, amount,phone);
        CashierService cashierService = new LocalCashier(receiptRepository, userRepository, productRepository);
        Receipt receipt = cashierService.buy(phone, productId);
        Mockito.when(receiptRepository.save(receipt)).thenReturn(null);

        assertTrue(receipt.getCustomerId().equals(phone));
        assertTrue(receipt.getAmount() == amount);
        //todo add more cases

    }

    private Product createProductWithPrice(double amount) {

        Product product = new Product();
        product.setDescription("Description");
        product.setMerchantId("00929181");
        product.setPrice(amount);
        return product;
    }

    private User getCustomerWithCredit(String id, double balance) {

        User  customer = new User();
        customer.setId(id);
        customer.setBalance(balance);
        return customer;

    }
}