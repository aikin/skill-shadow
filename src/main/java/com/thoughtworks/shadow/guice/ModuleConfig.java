package com.thoughtworks.shadow.guice;


import com.thoughtworks.shadow.guice.service.Hello;
import com.thoughtworks.shadow.guice.service.Log;
import com.thoughtworks.shadow.guice.service.HelloService;
import com.thoughtworks.shadow.guice.service.LogService;

import com.google.inject.AbstractModule;

public class ModuleConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(Hello.class).to(HelloService.class);
        bind(Log.class).to(LogService.class);
    }
}
