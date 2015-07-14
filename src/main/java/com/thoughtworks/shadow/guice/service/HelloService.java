package com.thoughtworks.shadow.guice.service;

import com.thoughtworks.shadow.guice.service.Hello;

public class HelloService implements Hello {

    public void sayHello() {
        System.out.println("Hello");
    }
}
