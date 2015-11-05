package fi.samssi.resttemplate.application.di;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public abstract class ModuleBinder extends AbstractBinder {
    @Override
    protected void configure() {
        install(module());
    }

    public abstract AbstractBinder module();
}
