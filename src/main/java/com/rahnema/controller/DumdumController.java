package com.rahnema.controller;

/**
 * generate fake data
 * Created by moien on 8/6/2017.
 */

import com.rahnema.model.User.User;
import com.rahnema.model.User.UserRepository;
import com.rahnema.model.buy.Product;
import com.rahnema.model.buy.ProductRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/dumdum")
@Named
public class DumdumController {


    @Inject
    UserRepository userRepository;
    @Inject
    ProductRepository productRepository;

    @GET
    @Path("/fake")
    public Response dumdum() {

        User user = new User();
        user.setBalance((1000));
        user.setId("9141026539");
        userRepository.save(user);

        User merchant = new User();
        user.setBalance((1000));
        user.setId("9121026539");
        userRepository.save(user);

        Product product = new Product();
        product.setId("dumdumExpensive");
        product.setPrice((8000));
        product.setMerchantId("9121026539");
        product.setDescription("Ya Ghamar Molook!");
        productRepository.save(product);

        Product product2 = new Product();
        product2.setId("dumdumCheap");
        product2.setPrice((1));
        product2.setMerchantId("9121026539");
        product2.setDescription("Ya Ghamar Molook 2!");
        productRepository.save(product2);


        return Response.status(200).build();


    }

}