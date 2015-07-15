package com.thoughtworks.shadow.guice.bindings.annotations;


public class Cat implements Animal {

    @Override
    public void say() {
        System.out.printf("i am cat ! \n");
    }
}
