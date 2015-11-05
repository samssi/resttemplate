package fi.samssi.resttemplate.application.config;

import fi.samssi.resttemplate.application.ServiceLocatorHolder;
import fi.samssi.resttemplate.application.property.ApplicationProperties;
import io.swagger.jaxrs.config.BeanConfig;

import javax.inject.Inject;
import java.util.List;

public class PropertyBasedBeanConfig extends BeanConfig {
    @Inject
    private ApplicationProperties applicationProperties;

    public PropertyBasedBeanConfig() {
        ServiceLocatorHolder.injectMembers(this);
        setVersion(applicationProperties.config().getString("swagger.version"));
        String schemes[] = {"http"};//asArray(applicationProperties.config().getStringList("swagger.schemes"));
        setSchemes(schemes);
        setHost(applicationProperties.config().getString("swagger.host"));
        setBasePath(applicationProperties.config().getString("swagger.basepath"));
        setResourcePackage(applicationProperties.config().getString("swagger.resource.package"));
        setScan(applicationProperties.config().getBoolean("swagger.classscan"));
    }

    private String[] asArray(List<String> array) {
        return array.stream().toArray(String[]::new);
    }


}
