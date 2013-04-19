package dk.statsbiblioteket.scape.dataconnector.interfaces;

import eu.scapeproject.model.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: abr
 * Date: 4/19/13
 * Time: 10:46 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Files {

    @GET
    @Path("{id}{version-id:(/[^/]*)}/")
    @Produces(MediaType.WILDCARD)
    File retrieveFile(@PathParam("id")
                      String id,
                      @PathParam("version-id")
                      String version_id);
}
