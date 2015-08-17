package org.arthan.support.listeners;

import org.arthan.support.filters.AuthenticationFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Артур on 17.08.2015.
 * Next to Ufa.
 */
public class Configurator implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        FilterRegistration.Dynamic registration = context.addFilter("authenticationFilter", new AuthenticationFilter());
        registration.setAsyncSupported(true);
        registration.addMappingForUrlPatterns(null, false, "/sessions", "/tickets");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
