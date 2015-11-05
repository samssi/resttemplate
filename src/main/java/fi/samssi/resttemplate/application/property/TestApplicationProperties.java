package fi.samssi.resttemplate.application.property;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import fi.samssi.resttemplate.application.property.ApplicationProperties;

public class TestApplicationProperties implements ApplicationProperties {
    @Override
    public Config config() {
        return ConfigFactory.load("test-context.properties");
    }
}
