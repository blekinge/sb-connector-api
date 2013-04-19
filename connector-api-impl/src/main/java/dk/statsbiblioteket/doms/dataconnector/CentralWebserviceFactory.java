package dk.statsbiblioteket.doms.dataconnector;

import dk.statsbiblioteket.doms.central.CentralWebservice;
import dk.statsbiblioteket.doms.central.CentralWebserviceService;
import dk.statsbiblioteket.doms.webservices.configuration.ConfigCollection;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
public class CentralWebserviceFactory {
    private static final QName CENTRAL_WEBSERVICE_SERVICE = new QName(
            "http://central.doms.statsbiblioteket.dk/",
            "CentralWebserviceService");

    private static CentralWebservice domsApi = null;

    private synchronized static void initialise() {
        if (domsApi != null){
            return;
        }

        Properties conf = ConfigCollection.getProperties();

        String urlEndpoint = conf.getProperty("dk.statsbiblioteket.doms.endpoint");
        String username = conf.getProperty("dk.statsbiblioteket.doms.username");
        String password = conf.getProperty("dk.statsbiblioteket.doms.password");
        URL domsWSAPIEndpoint;
        try {
            domsWSAPIEndpoint = new URL(urlEndpoint);
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL to DOMS not configured correctly. Was: " + urlEndpoint, e);
        }
        CentralWebservice serviceInstance = new CentralWebserviceService(domsWSAPIEndpoint, CENTRAL_WEBSERVICE_SERVICE).getCentralWebservicePort();
        Map<String, Object> domsAPILogin = ((BindingProvider) serviceInstance).getRequestContext();
        domsAPILogin.put(BindingProvider.USERNAME_PROPERTY, username);
        domsAPILogin.put(BindingProvider.PASSWORD_PROPERTY, password);
        domsApi = serviceInstance;
    }

    public static CentralWebservice getServiceInstance() {
        initialise();
        return domsApi;
    }

}
