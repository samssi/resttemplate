package fi.samssi.resttemplate.di;

import fi.samssi.resttemplate.resource.ExampleResource;
import fi.samssi.resttemplate.util.GsonWriter;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import io.swagger.jersey.listing.ApiListingResourceJSON;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spi.Container;
import org.glassfish.jersey.server.spi.ContainerLifecycleListener;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class ExampleResourceConfig extends ResourceConfig {
    public ExampleResourceConfig() {
        registerApplicationComponents();
        registerResources();
        registerSwagger();
    }

    public void registerResources() {
        register(ExampleResource.class);
    }

    public void registerApplicationComponents() {
        register(GsonWriter.class);
        register(new DevelopmentBinder());
        register(new ApplicationLifecycleListener());
    }

    public void registerSwagger() {
        new PropertyBasedBeanConfig();

        register(ApiListingResource.class);
        register(SwaggerSerializers.class);
    }
}
