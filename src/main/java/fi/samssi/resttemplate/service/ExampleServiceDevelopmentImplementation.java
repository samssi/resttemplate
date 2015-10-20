package fi.samssi.resttemplate.service;

import fi.samssi.resttemplate.domain.ExampleClass;

public class ExampleServiceDevelopmentImplementation implements ExampleService {
    public ExampleClass fetchExampleClass() {
        return new ExampleClass("Immutable development context string");
    }
}
