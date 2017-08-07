package com.rahnema.controller;

/**
 * rest controller for buy api
 * Created by moien on 8/6/2017.
 */

import com.google.gson.Gson;
import com.rahnema.model.buy.Receipt;
import com.rahnema.model.cashier.CashierService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/buy")
@Named
public class BuyController {

    @Inject
    private CashierService cashierService;


    @GET
    @Path("/{user}/{product}")
    public Response printMessage(@PathParam("user") String email, @PathParam("product") String product) {

        Receipt receipt = cashierService.buy(email, product);
        return Response.status(200).entity(new Gson().toJson(receipt)).build();
    }

}