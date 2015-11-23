package fi.samssi.resttemplate.server;

public class TestServerStartException extends RuntimeException {
    public TestServerStartException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
