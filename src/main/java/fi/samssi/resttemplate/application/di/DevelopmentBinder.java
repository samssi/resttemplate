package fi.samssi.resttemplate.application.di;

import fi.samssi.resttemplate.application.di.module.DevelopmentModule;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DevelopmentBinder extends ModuleBinder {
    @Override
    public AbstractBinder module() {
        return new DevelopmentModule();
    }
}
