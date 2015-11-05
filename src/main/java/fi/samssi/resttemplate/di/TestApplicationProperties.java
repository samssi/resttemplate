package fi.samssi.resttemplate.di;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class TestApplicationProperties implements ApplicationProperties {
    @Override
    public Config config() {
        return ConfigFactory.load("test-context.properties");
    }
}
