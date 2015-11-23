package fi.samssi.resttemplate.application;

import java.util.Optional;

public class ContextSelector {
    public static Context getSystemPropertyOverridableContext() {
        return getOverrideSystemContextProperty().orElseThrow(() -> new ContextException("Context selection failed! Context not defined!"));
    }

    private static Optional<Context> getOverrideSystemContextProperty() {
        try {
            return Optional.of(Context.fromContextParam(System.getProperty("server.context")));
        } catch (ContextException e) {
            return Optional.empty();
        }

    }
}
