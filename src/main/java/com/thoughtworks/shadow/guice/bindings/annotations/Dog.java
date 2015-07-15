package com.thoughtworks.shadow.guice.bindings.annotations;


public class Dog implements Animal {

    @Override
    public void say() {
        System.out.printf("i am dog, i am animal 2 ! \n");
    }
}
