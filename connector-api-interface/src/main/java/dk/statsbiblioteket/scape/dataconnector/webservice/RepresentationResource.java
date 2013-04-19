package dk.statsbiblioteket.scape.dataconnector.webservice;

import dk.statsbiblioteket.scape.dataconnector.Factory;
import eu.scapeproject.model.Representation;

import javax.ws.rs.Consumes;
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
@Path("/representation/{id}")
public class RepresentationResource  {


    /**
     * 5.4.14 Retrieve a Representation
     For fetching Representations without having to retrieve the METS representation of the whole Intellectual Entity a dedicated endpoint is exposed by the repository
     Path:
     /representation/<id>
     Method:
     HTTP/1.1 GET
     Parameters:
     Id: the id of the requested Representation
     Produces:
     A XML representation of the requested Representation
     Content-Type:
     text/xml
     */
    @GET
    @Produces(MediaType.TEXT_XML)
    public Representation getRepresentation(@PathParam("id") String id){
        return Factory.getFactory().getRepresentations().getRepresentation(id);
    }

    /**
     * 5.4.15 Update a Representation of an Intellectual Entity
     For updating a Representation of an Intellectual entity without sending a METS representation of the Intellectual Entity an endpoint is exposed by the repository. The repository has to create a new Version of the Intellectual Entity with the updated Representation.
     Path:
     /representation/<id>
     Parameters
     Id: the id of the Representation  to update
     Method
     HTTP/1.1 PUT
     Consumes
     A Representations'  XML representation.

     */
    @PUT
    @Consumes(MediaType.TEXT_XML)
    public void setRepresentation(@PathParam("id") String id, Representation representation){
        Factory.getFactory().getRepresentations().setRepresentation(id,representation);
    }
}
