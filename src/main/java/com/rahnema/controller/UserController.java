package com.rahnema.controller;

/**
 * rest controller for user api
 * Created by moien on 8/6/2017.
 */

import com.google.gson.Gson;
import com.rahnema.model.User.User;
import com.rahnema.model.User.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/user")
@Named
public class UserController {

    @Inject
    private UserRepository userRepository;


    @GET
    @Path("/{user}")
    public Response printMessage(@PathParam("user") String email) {

        User user = userRepository.get(email);
        return Response.status(200).entity(new Gson().toJson(user)).build();
    }


}