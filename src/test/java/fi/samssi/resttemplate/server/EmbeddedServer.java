package fi.samssi.resttemplate.server;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import fi.samssi.resttemplate.application.Application;
import fi.samssi.resttemplate.application.Context;
import fi.samssi.resttemplate.application.ContextSelector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.LoggerFactory;


import static fi.samssi.resttemplate.application.Context.DEV;
import static fi.samssi.resttemplate.application.Context.TEST;

public class EmbeddedServer {
   private static final Server server = new Server(8080);

    public static class DevContext {
        public static void main(String... args) {
            CustomContext.startServer(DEV);
        }
    }

    public static class TestContext {
        public static void main(String... args) {
            CustomContext.startServer(TEST);
        }
    }

    public static class CustomContext {
        public static void main(String... args) {
            Context context = ContextSelector.getSystemPropertyOverridableContext();
            startServer(context);
        }

        public static void startServer(Context context) {
            setupLogger();
            ServletHolder jerseyServletHolder = new ServletHolder(new org.glassfish.jersey.servlet.ServletContainer(new Application(context)));
            assignServlet(jerseyServletHolder);
            start();
        }
    }

    public static void setupLogger() {
        Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        rootLogger.setLevel(Level.INFO);
    }

    public static void assignServlet(ServletHolder servletHolder) {
        servletHolder.setInitOrder(0);
        servletContextHandler().addServlet(servletHolder, "/rest/*");
    }

    public static ServletContextHandler servletContextHandler() {
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/");
        server.setHandler(servletContextHandler);
        return servletContextHandler;
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
