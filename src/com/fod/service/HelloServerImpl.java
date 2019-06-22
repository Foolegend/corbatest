package com.fod.service;

public class HelloServerImpl extends HelloServerPOA{
    @Override
    public void sayHello(String name) {
        System.out.println("Hello ," + name + ".");

    }
}
