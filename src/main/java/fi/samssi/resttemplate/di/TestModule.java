package fi.samssi.resttemplate.di;

import fi.samssi.resttemplate.service.ExampleService;
import fi.samssi.resttemplate.service.ExampleServiceTestImplementation;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class TestModule extends AbstractBinder {
    @Override
    protected void configure() {
        bind(ExampleServiceTestImplementation.class).to(ExampleService.class);
        bind(TestApplicationProperties.class).to(ApplicationProperties.class);
    }
}
