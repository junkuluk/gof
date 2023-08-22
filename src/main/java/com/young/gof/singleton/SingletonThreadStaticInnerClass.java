package com.young.gof.singleton;

import java.io.Serial;
import java.io.Serializable;

public class SingletonThreadStaticInnerClass implements Serializable {
    @Serial
    private static final long serialVersionUID = 42L;
    private SingletonThreadStaticInnerClass() {}

    private static class SingletonThreadHolder{
        private static final SingletonThreadStaticInnerClass INSTANCE = new SingletonThreadStaticInnerClass();
    }
    public static SingletonThreadStaticInnerClass getInstance() {
        return SingletonThreadHolder.INSTANCE;
    }

    /*to prevent breaking singleton pattern by serialization overwrite below method
    protected Object readResolve(){
        return getInstance();
    }
    */
}
