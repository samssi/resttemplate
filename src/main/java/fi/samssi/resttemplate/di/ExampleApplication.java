package fi.samssi.resttemplate.di;

import fi.samssi.resttemplate.resource.ExampleResource;
import fi.samssi.resttemplate.util.GsonWriter;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spi.Container;
import org.glassfish.jersey.server.spi.ContainerLifecycleListener;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class ExampleApplication extends ResourceConfig {
    public ExampleApplication() {
        register(GsonWriter.class);
        registerApplicationComponents();
        registerResources();
    }

    public void registerResources() {
        register(ExampleResource.class);
    }

    public void registerApplicationComponents() {
        register(new DevelopmentBinder());
        register(new ApplicationLifecycleListener());

    }
}
