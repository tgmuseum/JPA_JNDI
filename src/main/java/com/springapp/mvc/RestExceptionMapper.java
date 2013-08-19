package com.springapp.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Scope;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 * Created with IntelliJ IDEA.
 * User: LSK
 * Date: 13. 8. 19
 * Time: 오후 1:37
 * To change this template use File | Settings | File Templates.
 */
@Scope("singleton")
@Provider
public class RestExceptionMapper implements ExceptionMapper<Throwable>, MessageSourceAware {

    private static final Log LOG = LogFactory.getLog(RestExceptionMapper.class);

    protected MessageSource messageSource;

    @Override
    public Response toResponse(Throwable t) {

        Response response = null;
        Object mesg = null;

        if (t instanceof WebApplicationException) {
            response = ((WebApplicationException) t).getResponse();
            if (response.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()) {
                LOG.error("An exception was caught by the JAX-RS framework: Status: " + response.getStatus() + " Message: " + response.getEntity(), t);
                mesg = "An exception was caught by the JAX-RS framework: Status: " + response.getStatus() + " Message: " + response.getEntity();
            } else if (response.getStatus() == Response.Status.FORBIDDEN.getStatusCode()) {
                LOG.warn("Someone tried to access a resource that was forbidden: Status: " + response.getStatus() + " Message: " + response.getEntity(), t);
                mesg = "Someone tried to access a resource that was forbidden: Status: " + response.getStatus() + " Message: " + response.getEntity();
            } else if (response.getStatus() == Response.Status.BAD_REQUEST.getStatusCode() && LOG.isDebugEnabled()) {
                LOG.debug("Bad Request: Status: " + response.getStatus() + " Message: " + response.getEntity(), t);
                mesg = "Bad Request: Status: " + response.getStatus() + " Message: " + response.getEntity();
            } else if (response.getStatus() == Response.Status.NOT_ACCEPTABLE.getStatusCode() && LOG.isDebugEnabled()) {
                LOG.debug("Not acceptable: Status: " + response.getStatus() + " Message: " + response.getEntity(), t);
                mesg = "Not acceptable: Status: " + response.getStatus() + " Message: " + response.getEntity();
            } else {
                LOG.error("An exception was caught by the JAX-RS framework: Status: " + response.getStatus() + " Message: " + response.getEntity(), t);
                mesg = "An exception was caught by the JAX-RS framework: Status: " + response.getStatus() + " Message: " + response.getEntity();
            }
        } else {
            LOG.error("An exception was caught by the JAX-RS framework: ", t);
            mesg = "An exception was caught by the JAX-RS framework: ";
        }

        if (response != null) {
            Object msg = response.getEntity();
            if (msg == null) {
                msg = "response.getEntity() is null : C8 개털이다. 아무것도 줄게 없다. ";
            }
            return Response.status(response.getStatus()).type(MediaType.TEXT_PLAIN).entity(msg).build();
        }

        if (response == null) {
            return Response.status(500).type(MediaType.TEXT_PLAIN).entity(
                    "response is null : C8 응답이 아예 없다."
            ).build();
        }

        // return Response.status(500).type(MediaType.TEXT_PLAIN).entity("An unknown or unreported error has occured. If the problem persists, please contact the administrator.").build();
        return Response.status(500).type(MediaType.TEXT_PLAIN).entity(
                response.getEntity().toString()
        ).build();
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}

