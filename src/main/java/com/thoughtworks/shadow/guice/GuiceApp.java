package com.thoughtworks.shadow.guice;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.thoughtworks.shadow.guice.bindings.Process;

public class GuiceApp {

    public static void main(String[] args) {

        final Injector injector = Guice.createInjector(new ModuleConfig());
        final Process service = injector.getInstance(Process.class);

        service.processMessage();

    }
}

