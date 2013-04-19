package dk.statsbiblioteket.scape.dataconnector.webservice;

import dk.statsbiblioteket.scape.dataconnector.Factory;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.IntellectualEntityCollection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: abr
 * Date: 4/19/13
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("/")
public class MiscResource {

    /**
     * In order to make fetching a whole set of entities feasible this GET method consumes a list of URIs sent with the request. It resolves the URIs to Intellectual Entities and creates a  response consisting of the corresponding METS representations. If at least one URI could not be resolved the implementation returns a HTTP 404 Not Found status message.
     * @return A text/uri-list of the entities to be retrieved
     */
    @POST
    @Path("entity-list")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.MULTIPART_FORM_DATA)
    public IntellectualEntityCollection getEntityList(
    ) {
        return Factory.getFactory().getMiscImpl().getEntityList();
    }



    /**
     * Ingestion is done by sending a SIP to this endpoint. The method returns instantly and supplies the User with an ID which can be used to request the status of the ingestion.
     * @param entity A XML representation of the entity
     * @return An Identifier which can be used to request the lifecycle status of the digital object ingested.
     */
    @POST
    @Path("entity-async")
    @Consumes(MediaType.TEXT_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public Identifier ingestEntityAsync(IntellectualEntity entity
    ) {
        return Factory.getFactory().getMiscImpl().ingestEntityAsync(entity);
    }
}
