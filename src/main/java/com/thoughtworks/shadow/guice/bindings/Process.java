package com.thoughtworks.shadow.guice.bindings;

import com.google.inject.Inject;

import com.google.inject.name.Named;
import com.thoughtworks.shadow.guice.bindings.annotations.Animal;
import com.thoughtworks.shadow.guice.bindings.annotations.Milk;
import com.thoughtworks.shadow.guice.bindings.linked.Hello;
import com.thoughtworks.shadow.guice.bindings.linked.Log;

public class Process {

    private Hello hello;
    private Log log;
    private Animal animal;
    private Animal animal2;

    @Inject
    @Named("Instance")
    private String injectByInstance;

    @Inject
    @Named("Name")
    private String name;

    @Inject
    private int age;

    @Inject
    public Process(final Hello hello, final Log log, final @Milk Animal animal, final @Named("Water") Animal animal2) {
        this.hello = hello;
        this.log = log;
        this.animal = animal;
        this.animal2 = animal2;
    }

    public void processMessage() {
        hello.sayHello();
        log.log();
        animal.say();
        animal2.say();
        System.out.printf(this.injectByInstance + "\n");
        System.out.printf(this.name + "---age is---:" + this.age);
    }

}
