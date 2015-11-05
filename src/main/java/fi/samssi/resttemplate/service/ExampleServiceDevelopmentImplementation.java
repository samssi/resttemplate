package fi.samssi.resttemplate.service;

import fi.samssi.resttemplate.application.property.ApplicationProperties;
import fi.samssi.resttemplate.domain.ExampleClass;

import javax.inject.Inject;

public class ExampleServiceDevelopmentImplementation implements ExampleService {
    @Inject
    private ApplicationProperties applicationProperties;

    public ExampleClass fetchExampleClass() {
        return new ExampleClass(applicationProperties.config().getString("example.service.message"));
    }
}
