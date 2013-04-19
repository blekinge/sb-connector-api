package dk.statsbiblioteket.scape.dataconnector;

import dk.statsbiblioteket.doms.webservices.configuration.ConfigCollection;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Bitstreams;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Entities;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Files;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Lifecycles;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Metadatas;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Miscs;
import dk.statsbiblioteket.scape.dataconnector.interfaces.Representations;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: abr
 * Date: 4/19/13
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Factory {

    private static Factory instance;

    public synchronized static Factory getFactory(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    private final Bitstreams bitstream;
    private final Entities entities;
    private final Files files;
    private final Lifecycles lifecycles;
    private final Metadatas metadatas;
    private final Miscs miscs;
    private final Representations representations;

    public Factory() {

        Properties conf = ConfigCollection.getProperties();

        String bitstreamClassName = conf.getProperty("dk.statsbiblioteket.scape.Bitstream.class");
        String entityClassName = conf.getProperty("dk.statsbiblioteket.scape.Entities.class");
        String fileClassName = conf.getProperty("dk.statsbiblioteket.scape.Files.class");
        String lifecycleClassName = conf.getProperty("dk.statsbiblioteket.scape.Lifecycles.class");
        String metadataClassName = conf.getProperty("dk.statsbiblioteket.scape.Metadatas.class");
        String miscClassName = conf.getProperty("dk.statsbiblioteket.scape.Representations.class");
        String representationClassName = conf.getProperty("dk.statsbiblioteket.scape.Representations.class");

        try {
            bitstream = (Bitstreams) Class.forName(bitstreamClassName).newInstance();
            entities = (Entities) Class.forName(entityClassName).newInstance();
            files = (Files) Class.forName(fileClassName).newInstance();
            lifecycles = (Lifecycles) Class.forName(lifecycleClassName).newInstance();
            metadatas = (Metadatas) Class.forName(metadataClassName).newInstance();
            miscs = (Miscs) Class.forName(miscClassName).newInstance();
            representations = (Representations) Class.forName(representationClassName).newInstance();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }



    public Bitstreams getBitstreamImpl(){
        return bitstream;
    }

    public Entities getEntityImpl(){
        return entities;
    }

    public Files getFileImpl(){
        return files;
    }

    public Lifecycles getLifecycleImpl(){
        return lifecycles;

    }

    public Miscs getMiscImpl(){
        return miscs;
    }

    public Metadatas getMetadataImpl(){
        return metadatas;
    }

    public Representations getRepresentations(){
        return representations;
    }
}
