package com.github.phillipkruger.loggingui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")
public class HelloEndpoint {
    private static final Logger  LOG = Logger.getLogger(HelloEndpoint.class.getName());
    
    @GET
    public String hello(){
        return hello("Someone");
    }
    
    @GET @Path("/{name}")
    public String hello(@PathParam("name") String name){
        LOG.log(Level.INFO, "{0} is saying hello", name);
        return "Goeie naand " + name;
    }
}
