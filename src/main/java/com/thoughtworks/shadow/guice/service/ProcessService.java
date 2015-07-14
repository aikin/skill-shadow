package com.thoughtworks.shadow.guice.service;

import com.thoughtworks.shadow.guice.service.Hello;
import com.thoughtworks.shadow.guice.service.Log;

import com.google.inject.Inject;

public class ProcessService {

    private Hello hello;
    private Log log;

    @Inject
    public ProcessService(final Hello hello, final Log log) {
        this.hello = hello;
        this.log = log;
    }

    public void processMessage() {
        hello.sayHello();
        log.log();
    }

}
