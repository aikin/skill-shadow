package com.thoughtworks.shadow.guice;


import com.thoughtworks.shadow.guice.ModuleConfig;
import com.thoughtworks.shadow.guice.service.ProcessService;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceApp {

    public static void main(String[] args) {

        final Injector injector = Guice.createInjector(new ModuleConfig());
        final ProcessService service = injector.getInstance(ProcessService.class);

        service.processMessage();

    }
}

