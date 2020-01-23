package com.epam.task.controller;

import com.epam.task.models.Advertisement;
import com.epam.task.service.AdvertisementService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/advertisements")
public class AdvertisementController {
    AdvertisementService adService = new AdvertisementService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add (Advertisement ad) {
        if (adService.add(ad)==null){
            return Response.status(201).entity("Advert created").build();
        }
        return Response.status(400).entity("Can't create advert with id = " + ad.getId() + " and user id = " + ad.getAuthorId()).build();
    }

    @GET
    @Path("/{adId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("adId") long id){
        if (adService.get(id) == null) {
            return Response.status(404).build();
        }
        return Response.status(200).entity(adService.get(id)).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(){
        List<Advertisement> ads = adService.get();
        if (ads.isEmpty()) {
            Response.status(404).build();
        }
        return Response.status(200).entity(adService.get()).build();

    }

    @GET
    @Path("/{authorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllByUserId(@PathParam("authorId") long id){
        List<Advertisement> ads = adService.findAllByUserId(id);

        if (ads.isEmpty()) {
            Response.status(404).build();
        }
        return Response.status(200).entity(adService.findAllByUserId(id)).build();
    }

    @DELETE
    @Path("/{adId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeById(@PathParam("adId") long id){
        if(adService.removeById(id)) {
            return Response.status(200).entity("Advert deleted").build();
        }
        return Response.status(404).entity("Can't delete advert with id = " + id).build();
    }

}

