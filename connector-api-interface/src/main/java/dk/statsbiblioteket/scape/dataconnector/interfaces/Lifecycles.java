package dk.statsbiblioteket.scape.dataconnector.interfaces;

import eu.scapeproject.model.LifecycleState;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: abr
 * Date: 4/19/13
 * Time: 10:46 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Lifecycles {
    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_XML)
    LifecycleState getLifecycle(@PathParam("id") String id);
}
