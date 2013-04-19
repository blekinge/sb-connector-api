package dk.statsbiblioteket.scape.dataconnector.webservice;

import dk.statsbiblioteket.scape.dataconnector.Factory;
import eu.scapeproject.dto.mets.MetsMetadata;
import eu.scapeproject.model.VersionList;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: abr
 * Date: 4/19/13
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("/metadata/{id}")
public class MetadataResource {

    /**
     * Retrieval of single metadata records of entities is done via a GET request. Since Intellectual Entities can have multiple versions there is an optional version identifier, which when omitted defaults to the most current version of the Intellectual Entity. When successful the response body is a XML representation of the corresponding metadata record.
     * @param id  the id of the requested metadata record
     * @param version_id the version of the requested entity (optional)
     * @return A XML representation of the requested metadata record according to the corresponding metadata’s schema
     */
    @GET
    @Path("{version-id:(/[^/]*)}/")
    @Produces(MediaType.TEXT_XML)
    public MetsMetadata getMetadata(@PathParam("id")
                                    String id,
                                    @PathParam("version-id")
                                    String version_id) {
        return Factory.getFactory().getMetadataImpl().getMetadata(id,version_id);
    }



    /**
     * In order to get a list of all versions of an Intellectual Entity a plain GET request can be sent to the implementation with the <id> parameter indicating which entity's versions to list. If successful the response consists of the Intellectual Entity's version identifiers  in a XML representation
     * @param id the id of the Intellectual Entity
     * @return A XML representation of all the entities version ids.
     */
    @GET
    @Produces(MediaType.TEXT_XML)
    public VersionList retrieveVersionList(@PathParam("id")
                                           String id
    ) {
        return Factory.getFactory().getMetadataImpl().retrieveVersionList(id);
    }

    /**
         * 5.4.16 Update the metadata of an Intellectual Entity
         When updating  only the metadata of an Intellectual Entity validity on binary files can be omitted, thereby  saving cpu cycles. An endpoint is exposed to clients for updating the metadata of an Intellectual entity, that consumes a METS representations of an Intellectual Entity.
         Path:
         /metadata/<id>
         Parameters
         Id: the id of the Intellectual Entity  to update
         Method
         HTTP/1.1 PUT
         Consumes
         An Intellectual Entity’s XML representation.

         */
    @PUT
    public void updateMetadata(@PathParam("id")
                               String id,
                               MetsMetadata metsMetadata){

        Factory.getFactory().getMetadataImpl().updateMetadata(id,metsMetadata);
    }

}
