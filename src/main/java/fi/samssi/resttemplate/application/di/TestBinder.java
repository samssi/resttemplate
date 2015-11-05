package fi.samssi.resttemplate.application.di;

import fi.samssi.resttemplate.application.di.module.TestModule;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class TestBinder extends ModuleBinder {
    @Override
    public AbstractBinder module() {
        return new TestModule();
    }
}
