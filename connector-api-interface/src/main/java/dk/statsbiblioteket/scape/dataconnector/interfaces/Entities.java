package dk.statsbiblioteket.scape.dataconnector.interfaces;

import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: abr
 * Date: 4/19/13
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Entities {
    @GET
       @Path("entity/{id}{version-id:(/[^/]*)}/")
       @Produces(MediaType.TEXT_XML)
    IntellectualEntity getEntity(
            @PathParam("id")
            String id,
            @PathParam("version-id")
            String version_id,
            @QueryParam("useReferences")
            @DefaultValue("yes")
            String useReferences
    );

    @POST
        @Path("entity")
        @Consumes(MediaType.TEXT_XML)
        @Produces(MediaType.TEXT_PLAIN)
    Identifier ingestEntity(IntellectualEntity entity
    );

    @PUT
        @Path("entity/{id}")
        @Consumes(MediaType.TEXT_XML)
    void updateEntity(@PathParam("id")
                      String id,
                      IntellectualEntity entity
    );
}
