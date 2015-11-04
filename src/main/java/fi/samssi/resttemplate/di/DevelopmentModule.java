package fi.samssi.resttemplate.di;

import fi.samssi.resttemplate.service.ExampleService;
import fi.samssi.resttemplate.service.ExampleServiceDevelopmentImplementation;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DevelopmentModule extends AbstractBinder {
    @Override
    protected void configure() {
        bind(ExampleServiceDevelopmentImplementation.class).to(ExampleService.class);
        bind(DevelopmentApplicationProperties.class).to(ApplicationProperties.class);
    }
}
