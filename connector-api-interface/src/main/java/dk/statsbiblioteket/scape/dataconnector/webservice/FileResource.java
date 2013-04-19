package dk.statsbiblioteket.scape.dataconnector.webservice;

import dk.statsbiblioteket.scape.dataconnector.Factory;
import eu.scapeproject.model.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: abr
 * Date: 4/19/13
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("/file/")
public class FileResource {

    /**
     * 5.4.8 Retrieve a File
     * For fetching Files associated with Intellectual Entities the implementation exposes a HTTP GET endpoint.
     * Requests sent to this endpoint must have a <id> parameter indicating which File to fetch. The parameter
     * <version-id> indicating the version to fetch is optional and defaults to the most current version of the
     * File. Depending on the Storage Strategy the response body is the binary file with the corresponding Content-Type
     * set by the repository or a HTTP 302 redirect in the case of referenced content.
     * Path:
     * /file/<id>/<version-id>/
     * Method
     * HTTP/1.1 GET
     * Content-Type
     * depends on File's metadata, but defaults to application/octet-stream.
     *
     * @param id         the id of the requested file
     * @param version_id the version of the Intellectual Entity (optional)
     * @return the file requested or a redirect to the file when using referenced content.
     */
    @GET
    @Path("{id}{version-id:(/[^/]*)}/")
    @Produces(MediaType.WILDCARD)
    public File retrieveFile(@PathParam("id")
                             String id,
                             @PathParam("version-id")
                             String version_id) {
        return Factory.getFactory().getFileImpl().retrieveFile(id, version_id);
    }

}
