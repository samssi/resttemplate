package fi.samssi.resttemplate.application;

import fi.samssi.resttemplate.filter.CORSResponseFilter;
import fi.samssi.resttemplate.resource.ExampleResource;
import fi.samssi.resttemplate.util.GsonWriter;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends ResourceConfig {
    public Application(final Context context) {
        registerApplicationComponents(context);
        registerResources();
        registerSwagger();
    }

    public void registerApplicationComponents(final Context context) {
        register(GsonWriter.class);
        register(context.binder());
        register(new ApplicationLifecycleListener());
        register(new CORSResponseFilter());
    }

    public void registerResources() {
        register(ExampleResource.class);
    }



    public void registerSwagger() {
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);
    }
}
