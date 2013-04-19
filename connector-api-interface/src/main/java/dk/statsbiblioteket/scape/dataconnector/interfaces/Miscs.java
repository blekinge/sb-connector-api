package dk.statsbiblioteket.scape.dataconnector.interfaces;

import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.IntellectualEntityCollection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abr
 * Date: 4/19/13
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Miscs {
    @POST
    @Path("entity-list")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.MULTIPART_FORM_DATA)
    IntellectualEntityCollection getEntityList(
    );

    @POST
    @Path("entity-async")
    @Consumes(MediaType.TEXT_XML)
    @Produces(MediaType.TEXT_PLAIN)
    Identifier ingestEntityAsync(IntellectualEntity entity
    );
}
