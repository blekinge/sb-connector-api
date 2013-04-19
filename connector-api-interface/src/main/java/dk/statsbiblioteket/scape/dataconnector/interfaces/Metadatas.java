package dk.statsbiblioteket.scape.dataconnector.interfaces;

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
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Metadatas {
    @GET
    @Path("{version-id:(/[^/]*)}/")
    @Produces(MediaType.TEXT_XML)
    MetsMetadata getMetadata(@PathParam("id")
                             String id,
                             @PathParam("version-id")
                             String version_id);

    @GET
                                    @Produces(MediaType.TEXT_XML)
    VersionList retrieveVersionList(@PathParam("id")
                                    String id
    );

    @PUT
    void updateMetadata(@PathParam("id")
                        String id,
                        MetsMetadata metsMetadata);
}
