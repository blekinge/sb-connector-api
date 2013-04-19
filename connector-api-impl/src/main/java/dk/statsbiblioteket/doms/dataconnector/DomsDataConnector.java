package dk.statsbiblioteket.doms.dataconnector;

import dk.statsbiblioteket.doms.central.CentralWebservice;
import dk.statsbiblioteket.doms.central.CentralWebserviceService;
import dk.statsbiblioteket.doms.webservices.configuration.ConfigCollection;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Bitstreams;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Entities;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Files;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Lifecycles;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Metadatas;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Miscs;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Representations;
import eu.scapeproject.dto.mets.MetsMetadata;
import eu.scapeproject.model.BitStream;
import eu.scapeproject.model.File;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.IntellectualEntityCollection;
import eu.scapeproject.model.LifecycleState;
import eu.scapeproject.model.Representation;
import eu.scapeproject.model.VersionList;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: abr
 * Date: 4/19/13
 * Time: 2:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class DomsDataConnector implements Bitstreams,Entities,Files,Lifecycles,Metadatas,Miscs,Representations {


    public DomsDataConnector() {

        Properties conf = ConfigCollection.getProperties();
        CentralWebservice doms = CentralWebserviceFactory.getServiceInstance();
    }

    @Override
    public BitStream getBitstream(String id, String version_id) {

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IntellectualEntity getEntity(@PathParam("id") String id, @PathParam("version-id") String version_id, @QueryParam("useReferences") @DefaultValue("yes") String useReferences) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Identifier ingestEntity(IntellectualEntity entity) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateEntity(@PathParam("id") String id, IntellectualEntity entity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public File retrieveFile(@PathParam("id") String id, @PathParam("version-id") String version_id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public LifecycleState getLifecycle(@PathParam("id") String id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MetsMetadata getMetadata(@PathParam("id") String id, @PathParam("version-id") String version_id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public VersionList retrieveVersionList(@PathParam("id") String id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateMetadata(@PathParam("id") String id, MetsMetadata metsMetadata) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IntellectualEntityCollection getEntityList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Identifier ingestEntityAsync(IntellectualEntity entity) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Representation getRepresentation(@PathParam("id") String id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setRepresentation(@PathParam("id") String id, Representation representation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
