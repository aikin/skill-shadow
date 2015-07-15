package com.thoughtworks.shadow.guice.bindings;

import com.google.inject.Inject;

import com.thoughtworks.shadow.guice.bindings.annotations.Animal;
import com.thoughtworks.shadow.guice.bindings.annotations.Milk;
import com.thoughtworks.shadow.guice.bindings.linked.Hello;
import com.thoughtworks.shadow.guice.bindings.linked.Log;

public class ProcessService {

    private Hello hello;
    private Log log;
    private Animal animal;

    @Inject
    public ProcessService(final Hello hello, final Log log, final @Milk Animal animal) {
        this.hello = hello;
        this.log = log;
        this.animal = animal;
    }

    public void processMessage() {
        hello.sayHello();
        log.log();
        animal.say();
    }

}
