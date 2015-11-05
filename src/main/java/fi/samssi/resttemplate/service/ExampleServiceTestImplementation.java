package fi.samssi.resttemplate.service;

import fi.samssi.resttemplate.domain.ExampleClass;

public class ExampleServiceTestImplementation implements ExampleService {
    @Override
    public ExampleClass fetchExampleClass() {
        return new ExampleClass("Immutable test context string");
    }
}
