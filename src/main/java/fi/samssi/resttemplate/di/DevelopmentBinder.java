package fi.samssi.resttemplate.di;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DevelopmentBinder extends ModuleBinder {
    @Override
    public AbstractBinder module() {
        return new DevelopmentModule();
    }
}
