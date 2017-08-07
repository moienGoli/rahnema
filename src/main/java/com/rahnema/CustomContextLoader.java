package com.rahnema;


import com.rahnema.db.MorphiaObj;
import org.jboss.resteasy.plugins.spring.SpringContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * custom context loader to load morphia before head
 * Created by moien
 */
public class CustomContextLoader extends SpringContextLoaderListener {

    public void contextInitialized(ServletContextEvent event) {
        MorphiaObj.initMorphia();
        super.contextInitialized(event);
    }
}