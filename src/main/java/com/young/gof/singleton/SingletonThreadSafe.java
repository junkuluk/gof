package com.young.gof.singleton;

public class SingletonThreadSafe {

    private static SingletonThreadSafe instance;

    private SingletonThreadSafe(){}

    //it is thread safe but performance issue might arise.
    public static synchronized SingletonThreadSafe getInstance(){
        if(instance == null){
            instance = new SingletonThreadSafe();
        }
        return instance;
    }
}
