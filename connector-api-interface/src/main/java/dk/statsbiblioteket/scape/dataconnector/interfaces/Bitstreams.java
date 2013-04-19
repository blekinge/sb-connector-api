package dk.statsbiblioteket.scape.dataconnector.interfaces;

import eu.scapeproject.model.BitStream;

/**
 * Created with IntelliJ IDEA.
 * User: abr
 * Date: 4/19/13
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Bitstreams {


    BitStream getBitstream(String id,
                             String version_id);
}
