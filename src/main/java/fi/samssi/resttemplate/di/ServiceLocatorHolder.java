package fi.samssi.resttemplate.di;

import org.glassfish.hk2.api.ServiceLocator;

public class ServiceLocatorHolder {
    public static void injectMembers(Object targetObject) {
        ServiceLocator serviceLocator = ApplicationLifecycleListener.serviceLocator;
        serviceLocator.inject(targetObject);
    }
}
