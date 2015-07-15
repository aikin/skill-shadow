package com.thoughtworks.shadow.guice;


import com.google.inject.AbstractModule;

import com.thoughtworks.shadow.guice.bindings.annotations.Animal;
import com.thoughtworks.shadow.guice.bindings.annotations.Cat;
import com.thoughtworks.shadow.guice.bindings.annotations.Dog;
import com.thoughtworks.shadow.guice.bindings.annotations.Milk;
import com.thoughtworks.shadow.guice.bindings.linked.Hello;
import com.thoughtworks.shadow.guice.bindings.linked.HelloService;
import com.thoughtworks.shadow.guice.bindings.linked.Log;
import com.thoughtworks.shadow.guice.bindings.linked.LogService;

public class ModuleConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(Hello.class).to(HelloService.class);
        bind(Log.class).to(LogService.class);
        bind(Animal.class).annotatedWith(Milk.class).to(Cat.class);
        bind(Animal.class).to(Dog.class);
    }
}
