package com.epam.task.controller;

import com.epam.task.models.User;
import com.epam.task.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserController {
    UserService userService = new UserService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(User user) {
        if(userService.add(user) == null) {
            return Response.status(400).entity("Can't create user with id = " + user.getUserId()).build();

        }
        return Response.status(201).entity("User created").build();
    }

    @DELETE
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeById(@PathParam("userId") long id) {

        if(userService.removeById(id)) {
            return Response.status(200).entity("User deleted").build();
        }
        return Response.status(404).entity("Can't delete user with id = " + id).build();

    }
}
