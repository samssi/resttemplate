package fi.samssi.resttemplate.di;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class DevelopmentApplicationProperties implements ApplicationProperties {
    private final Config config = ConfigFactory.load("dev-context.properties");
    // TODO: use ConfigBeanFactory to load swagger settings

    @Override
    public Config config() {
        return config;
    }
}
