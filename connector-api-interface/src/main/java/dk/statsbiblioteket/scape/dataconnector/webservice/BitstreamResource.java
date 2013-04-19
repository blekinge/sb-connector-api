package dk.statsbiblioteket.scape.dataconnector.webservice;

import dk.statsbiblioteket.scape.dataconnector.Factory;
import eu.scapeproject.model.BitStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bitstream/{id}")
public class BitstreamResource  {



    /**
     * 5.4.9 Retrieve named bit streams
     * For fetching a named subset of Files, such as an entry in an ARC container, the implementation exposes a HTTP GET method. The mandatory parameter <id> is the identifier of the requested bit stream in the Intellectual Entity. Depending on the Storage Strategy the implementation returns the bit stream directly in the response body, or it redirects the request using HTTP 302 to the referenced content. This requires special care when using Referenced Content as a Storage Strategy since the implementation is only able to redirect to referenced bit streams, making the redirect target responsible for answering the request properly.
     * Content-Type
     * depends on content's type, but defaults to application/octet-stream.
     *
     * @param id         the id of the requested binary content
     * @param version_id the version of the requested bit stream's parent Intellectual Entity (optional)
     * @return the binary content associated requested or a redirect to the binary content.
     */
    @GET
    @Path("{version-id:(/[^/]*)}/")
    @Produces(MediaType.WILDCARD)
    public BitStream getBitstream(@PathParam("id")
                                    String id,
                                    @PathParam("version-id")
                                    String version_id) {
        return Factory.getFactory().getBitstreamImpl().getBitstream(id,version_id);
    }
}
