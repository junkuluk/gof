package com.young.gof.singleton;

public class SingletonThreadEagerInit {

    //eager initialization
    private static final SingletonThreadEagerInit INSTANCE = new SingletonThreadEagerInit();

    private SingletonThreadEagerInit() {}

    //it is thread safe but performance issue might arise.
    public static synchronized SingletonThreadEagerInit getInstance() {
        return INSTANCE;
    }
}
