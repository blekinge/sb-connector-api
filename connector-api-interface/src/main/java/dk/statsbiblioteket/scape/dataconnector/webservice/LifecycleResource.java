package dk.statsbiblioteket.scape.dataconnector.webservice;

import dk.statsbiblioteket.scape.dataconnector.Factory;
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
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("/lifecycle/")
public class LifecycleResource {
    /**
     * 5.4.13 Retrieve the lifecycle status of a entity
     In order  to access the lifecycle status of a Intellectual Entity without having to fetch the whole METS representation an endpoint for retrieving  this significant property is exposed by the repository.
     Path
     /lifecycle/<id>
     Method
     HTTP/1.1 GET
     Produces
     A XML representation of the lifecycle status
     Content-Type
     text/xml
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_XML)
    public LifecycleState getLifecycle(@PathParam("id") String id){
        return Factory.getFactory().getLifecycleImpl().getLifecycle(id);
    }
}
