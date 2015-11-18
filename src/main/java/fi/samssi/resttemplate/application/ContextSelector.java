package fi.samssi.resttemplate.application;

import java.util.Optional;

public class ContextSelector {
    public static Context getSystemPropertyOverridableContext(Context context) {
        return getOverrideSystemContextProperty().orElse(context);
    }

    private static Optional<Context> getOverrideSystemContextProperty() {
        try {
            return Optional.of(Context.fromContextParam(System.getProperty("server.context")));
        } catch (ContextException e) {
            return Optional.empty();
        }

    }
}
