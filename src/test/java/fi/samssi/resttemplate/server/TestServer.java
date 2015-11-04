package fi.samssi.resttemplate.server;

import fi.samssi.resttemplate.di.Context;
import fi.samssi.resttemplate.di.ExampleResourceConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import static fi.samssi.resttemplate.di.Context.DEV;
import static fi.samssi.resttemplate.di.Context.TEST;

public class TestServer {
   private static final Server server = new Server(8080);

    public static class DevContext {
        public static void main(String... args) {
            ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
            servletContextHandler.setContextPath("/");
            server.setHandler(servletContextHandler);

            ServletHolder jerseyServletHolder = new ServletHolder(new org.glassfish.jersey.servlet.ServletContainer(new ExampleResourceConfig(DEV)));
            jerseyServletHolder.setInitOrder(0);
            servletContextHandler.addServlet(jerseyServletHolder, "/rest/*");

            start();
        }
    }

    public static class TestContext {
        public static void main(String... args) {
            ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
            servletContextHandler.setContextPath("/");
            server.setHandler(servletContextHandler);

            ServletHolder jerseyServletHolder = new ServletHolder(new org.glassfish.jersey.servlet.ServletContainer(new ExampleResourceConfig(TEST)));
            jerseyServletHolder.setInitOrder(0);
            servletContextHandler.addServlet(jerseyServletHolder, "/rest/*");

            start();
        }
    }

    public static void start() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            throw new TestServerStartException("Server failed!", e);
        } finally {
            server.destroy();
        }

    }
}
