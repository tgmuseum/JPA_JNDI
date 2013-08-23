package com.springapp.mvc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: LSK
 * Date: 13. 8. 16
 * Time: 오후 6:13
 * To change this template use File | Settings | File Templates.
 */
@Component
@Scope("singleton")
@Path("/test")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class RestController {

    @GET
    @Path("/aaa")
    public ComnRes testJaxb() {

        ComnRes comnRes = new ComnRes();

        return comnRes;
    }
}
