package fi.samssi.resttemplate.application;

import fi.samssi.resttemplate.application.config.PropertyBasedBeanConfig;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.spi.Container;
import org.glassfish.jersey.server.spi.ContainerLifecycleListener;

public class ApplicationLifecycleListener implements ContainerLifecycleListener {
    public static ServiceLocator serviceLocator;

    public void onStartup(final Container container) {
        serviceLocator = container.getApplicationHandler().getServiceLocator();
        new PropertyBasedBeanConfig();
    }

    public void onReload(final Container container) {

    }

    public void onShutdown(final Container container) {

    }
}