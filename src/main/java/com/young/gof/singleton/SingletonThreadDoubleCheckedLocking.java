package com.young.gof.singleton;

public class SingletonThreadDoubleCheckedLocking {
    private static volatile SingletonThreadDoubleCheckedLocking instance;
    private SingletonThreadDoubleCheckedLocking() {}

    public static SingletonThreadDoubleCheckedLocking getInstance() {
        if (instance == null) {
            synchronized (SingletonThreadDoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new SingletonThreadDoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
}
