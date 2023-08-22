package com.young.gof.singleton;

public class SingletonNotSafe {

    private static SingletonNotSafe instance;

    private SingletonNotSafe() {}

    //below method is not thread safe
    public static SingletonNotSafe getInstance() {
        if (instance == null) {
            instance = new SingletonNotSafe();
        }
        return instance;
    }
}
