package fi.samssi.resttemplate.server;

import fi.samssi.resttemplate.App;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.net.URI;

public class TestServer {
    private static final org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8080);

    public static class DevContext {
        public static void main(String... args) {
            server.setHandler(context());
            ServletHolder jerseyServletHolder = context().addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
            jerseyServletHolder.setInitOrder(0);
            jerseyServletHolder.setInitParameter("jersey.config.server.provider.classnames", App.class.getCanonicalName());
            start();
        }
    }

    public static void start() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            throw new TestServerStartException("Server startup failed!", e);
        } finally {
            server.destroy();
        }

    }

    public static ServletContextHandler context() {
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/");
        return servletContextHandler;
    }

}
