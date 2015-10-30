package fi.samssi.resttemplate.resource;

import fi.samssi.resttemplate.domain.ExampleClass;
import fi.samssi.resttemplate.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("examples")
@Api(value = "examples")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {
    @Inject
    private ExampleService exampleService;

    @GET
    @Path("example")
    @ApiOperation(value = "Returns example object",
                    response = ExampleClass.class)
    @Produces(MediaType.APPLICATION_JSON)
    public ExampleClass getExampleClass() {
        return exampleService.fetchExampleClass();
    }
}
