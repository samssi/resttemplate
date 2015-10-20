package fi.samssi.resttemplate.resource;

import fi.samssi.resttemplate.domain.ExampleClass;
import fi.samssi.resttemplate.service.ExampleService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("examples")
public class ExampleResource {
    @Inject
    private ExampleService exampleService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getExampleClass() {
        return exampleService.fetchExampleClass().toString();
    }
}
