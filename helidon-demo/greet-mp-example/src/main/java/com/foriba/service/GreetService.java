package com.foriba.service;


import org.eclipse.microprofile.metrics.annotation.Metric;

import javax.enterprise.context.RequestScoped;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
@RequestScoped
public class GreetService{

    private static String message = "Hello";

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String defaultGreet()
    {
        return "Greetings from Helidon!";
    }

    @GET
    @Path("/greet/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String greet(@PathParam("name") String name)
    {
        return message + " " + name;
    }

    @POST
    @Path("/greet/settings/{greetMessage}")
    @Produces(MediaType.TEXT_PLAIN)
    public String changeGreetMessage(@PathParam("greetMessage") String greetMessage)
    {
        message = greetMessage;
        return "Message changed successfully";
    }
}
