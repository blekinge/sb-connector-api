package dk.statsbiblioteket.scape.dataconnector.webservice;

import dk.statsbiblioteket.scape.dataconnector.Factory;
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
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("/entity/")
public class EntityResource {


    /**
        * Retrieval of entities is done via a GET request. Since Intellectual Entities can have multiple versions there is
        * an optional version identifier, which when omitted defaults to the most current version of the Intellectual
        * Entity. When successful the response body is a METS representation of the Intellectual Entity. The parameter
        * useReferences controls wether the response is created using references to the metadata via <mdRef> elements or
        * if the metadata should be wrapped inside <mdWrap> elements in the METS document.
        *
        * @param id the id of the requested Intellectual Entity
        * @param version_id the version of the requested entity (optional)
        * @param useReferences Wether to wrap metadata inside <mdWrap> elements or to reference the metadata using<mdref>
        *                      elements. Defaults to yes.
        * @return A XML representation of the requested Intellectual Entity version
        */
       @GET
       @Path("{id}{version-id:(/[^/]*)}/")
       @Produces(MediaType.TEXT_XML)
       public IntellectualEntity getEntity(
               @PathParam("id")
               String id,
               @PathParam("version-id")
               String version_id,
               @QueryParam("useReferences")
               @DefaultValue("yes")
               String useReferences
       ) {
           return Factory.getFactory().getEntityImpl().getEntity(id, version_id, useReferences);
       }

    /**
      * Ingestion of digital objects is done by sending a METS representation of an Intellectual Entity in the body of a HTTP POST request, which gets validated and persisted in the repository. If validation does not succeed the implementation returns a HTTP 415 “Unsupported Media Type” status message. When successful the response body is a plain text document consisting of the ingested entity's identifier.
      * @param entity A XML representation of the entity
      * @return The Intellectual Entity identifier
      */
     @POST
     @Consumes(MediaType.TEXT_XML)
     @Produces(MediaType.TEXT_PLAIN)
     public Identifier ingestEntity(IntellectualEntity entity
     ) {
         return Factory.getFactory().getEntityImpl().ingestEntity(entity);
     }



    /**
     * In order to allow updating of Intellectual Entities the implementation exposes this HTTP  PUT endpoint. The mandatory parameter <id> tells the repository which Intellectual Entity is to be updated. The request must include the updated METS representation of the entity in the request body.
     * @param id the id of the Intellectual Entity to update
     * @param entity A digital object's XML representation.
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.TEXT_XML)
    public void updateEntity(@PathParam("id")
                             String id,
                             IntellectualEntity entity
    ) {
        Factory.getFactory().getEntityImpl().updateEntity(id,entity);
    }
}
