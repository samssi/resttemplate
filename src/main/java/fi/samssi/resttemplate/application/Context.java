package fi.samssi.resttemplate.application;

import fi.samssi.resttemplate.application.di.binder.DevelopmentBinder;
import fi.samssi.resttemplate.application.di.binder.TestBinder;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import static com.google.common.base.Strings.isNullOrEmpty;

public enum Context {
    DEV("dev") {
        @Override
        public AbstractBinder binder() {
            return new DevelopmentBinder();
        }
    },
    TEST("test") {
        @Override
        public AbstractBinder binder() {
            return new TestBinder();
        }
    },
    PRODUCTION("production") {
        @Override
        public AbstractBinder binder() {
            throw new RuntimeException("Production context not implemented yet.");
        }
    };

    private final String contextParam;

    Context(String contextParam) {
        this.contextParam = contextParam;
    }

    public static Context fromContextParam(final String contextParam) {
        if(!isNullOrEmpty(contextParam)) {
            for (Context context : Context.values()) {
                if (contextParam.equalsIgnoreCase(context.contextParam)) {
                    return context;
                }
            }
        }
        throw new ContextException("Unknown context.");
    }

    public abstract AbstractBinder binder();
}
