package fi.samssi.resttemplate.application;

import org.glassfish.hk2.api.ServiceLocator;

public class ServiceLocatorHolder {
    public static void injectMembers(final Object targetObject) {
        ServiceLocator serviceLocator = ApplicationLifecycleListener.serviceLocator;
        serviceLocator.inject(targetObject);
    }
}
