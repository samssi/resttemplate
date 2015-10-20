package fi.samssi.resttemplate.di;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DevelopmentBinder extends AbstractBinder {
    @Override
    protected void configure() {
        install(new DevelopmentModule());
    }
}
