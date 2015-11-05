package fi.samssi.resttemplate.service;

import fi.samssi.resttemplate.application.property.ApplicationProperties;
import fi.samssi.resttemplate.domain.ExampleClass;

import javax.inject.Inject;

public class ExampleServiceTestImplementation implements ExampleService {
    @Inject
    private ApplicationProperties applicationProperties;

    @Override
    public ExampleClass fetchExampleClass() {
        return new ExampleClass(applicationProperties.config().getString("example.service.message"));
    }
}
