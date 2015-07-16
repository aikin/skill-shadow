package com.thoughtworks.shadow.guice;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

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

        // Since the compiler can't check the string, we recommend using @Named sparingly.
        bind(Animal.class).annotatedWith(Names.named("Water")).to(Dog.class);

        bind(String.class).annotatedWith(Names.named("Instance")).toInstance("inject by instance !");

        bind(String.class).annotatedWith(Names.named("Name")).toInstance("aikin");
    }

    @Provides
     public int getAge() { // 和方法名无关

        System.out.println("run @Provides");
        return 22;
    }
}
