package fi.samssi.resttemplate.di;

import io.swagger.jaxrs.config.BeanConfig;

public class PropertyBasedBeanConfig extends BeanConfig {
    // TODO: these come from property files when they are implemented
    private static String VERSION = "v1";
    private static String[] SCHEMES = new String[] {"http"};
    private static String HOST = "localhost:8080";
    private static String BASE_PATH = "/rest";
    private static String RESOURCE_PACKAGE = "fi.samssi.resttemplate.resource";
    private static boolean CLASS_SCAN = true;

    public PropertyBasedBeanConfig() {
        setVersion(VERSION);
        setSchemes(SCHEMES);
        setHost(HOST);
        setBasePath(BASE_PATH);
        setResourcePackage(RESOURCE_PACKAGE);
        setScan(CLASS_SCAN);
    }


}
