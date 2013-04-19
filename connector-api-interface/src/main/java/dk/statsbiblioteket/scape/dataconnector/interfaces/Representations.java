package dk.statsbiblioteket.scape.dataconnector.interfaces;

import eu.scapeproject.model.Representation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: abr
 * Date: 4/19/13
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Representations {
    @GET
    @Produces(MediaType.TEXT_XML)
    Representation getRepresentation(@PathParam("id") String id);

    @PUT
    @Consumes(MediaType.TEXT_XML)
    void setRepresentation(@PathParam("id") String id, Representation representation);
}
