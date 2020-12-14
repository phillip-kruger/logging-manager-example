package com.github.phillipkruger.loggingui;

import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloEndpoint {
    private static final Logger  LOG = Logger.getLogger(HelloEndpoint.class.getName());
    
    @GET
    public String hello(){
        LOG.info("Someone is saying hello");
        return "Goeie naand";
    }
    
}
